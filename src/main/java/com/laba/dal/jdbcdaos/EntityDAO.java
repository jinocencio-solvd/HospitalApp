package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IEntityDAO;
import com.laba.utils.ConnectionPool;
import com.laba.utils.StringUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class EntityDAO<T> implements IEntityDAO<T> {

    protected abstract String getTableName();

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private void setAutoCommit(Boolean autoCommit, Connection connection) {
        try {
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void rollbackConnection(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        List<T> entityList = new ArrayList<>();
        String query = "SELECT * FROM " + getTableName();

        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entityList.add(getEntity(rs));
            }
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return entityList;
    }

    private T getEntity(ResultSet rs) throws SQLException {
        Map<String, String> columnMap = new HashMap<>();

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            columnMap.put(columnName, rs.getString(columnName));
        }
        return createModelFromMap(columnMap);
    }

    @Override
    public T getById(int id) {
        T entity = null;
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?;";

        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entity = getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return entity;
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?;";

        Connection connection = connectionPool.getConnection();
        setAutoCommit(false, connection);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            setAutoCommit(true, connection);
            connectionPool.releaseConnection(connection);

        }
    }

    private int prepareStatementOperations(PreparedStatement ps, Map<String, Object> entityMap)
        throws SQLException {
        int idx = 1;
        for (String key : entityMap.keySet()) {
            Object colValue = entityMap.get(key);
            if (colValue instanceof String) {
                ps.setString(idx, (String) colValue);
            } else if (colValue instanceof Integer) {
                ps.setInt(idx, (Integer) colValue);
            } else if (colValue instanceof Date) {
                ps.setDate(idx, (Date) colValue);
            } else if (colValue instanceof Time) {
                ps.setTime(idx, (Time) colValue);
            }
            idx++;
        }
        return idx;
    }

    @Override
    public void save(T entity) {
        Map<String, Object> entityMap = mapColumnNamesToModelGetters(entity);
        entityMap.remove("id");
        Set<String> entityCols = entityMap.keySet();
        String query =
            "INSERT INTO " + getTableName() + " " + StringUtil.formatCollectionsString(entityCols)
                + " VALUES ("
                + "(?), ".repeat(entityCols.size() - 1) + "(?))";

        Connection connection = connectionPool.getConnection();
        setAutoCommit(false, connection);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            prepareStatementOperations(ps, entityMap);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            setAutoCommit(true, connection);
            connectionPool.releaseConnection(connection);
        }
    }

    private String queryUpdateBuilder(T entity) {
        Map<String, Object> entityMap = mapColumnNamesToModelGetters(entity);

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE ").append(getTableName()).append(" SET ");
        for (String col : entityMap.keySet()) {
            queryBuilder.append(col).append(" = ?, ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
        queryBuilder.append(" WHERE id = ?");

        return queryBuilder.toString();
    }

    @Override
    public void update(T entity) {
        String query = queryUpdateBuilder(entity);
        Map<String, Object> entityMap = mapColumnNamesToModelGetters(entity);

        Connection connection = connectionPool.getConnection();
        setAutoCommit(false, connection);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            int idx = prepareStatementOperations(ps, entityMap);
            ps.setInt(idx, (Integer) entityMap.get("id"));
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            setAutoCommit(true, connection);
            connectionPool.releaseConnection(connection);
        }
    }

    protected Constructor<?> getWildTypeConstructor() {
        Type genericSuper = getClass().getGenericSuperclass();
        Type t = ((ParameterizedType) genericSuper).getActualTypeArguments()[0];
        Constructor<?> c = null;
        try {
            c = Class.forName(t.getTypeName()).getConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return c;
    }

    protected Map<String, Object> mapColumnNamesToModelGetters(T entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        Class<?> model = entity.getClass();
        Field[] modelFields = model.getDeclaredFields();
        for (Field field : modelFields) {
            String fieldName = field.getName();
            String columnName = StringUtil.camelToSnakeCase(fieldName);
            String getterMethodName = StringUtil.getGetterOrSetterString("get", columnName);
            try {
                Method getMethod = model.getMethod(getterMethodName);
                getters.put(columnName, getMethod.invoke(entity));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return getters;
    }

    protected T createModelFromMap(Map<String, String> columnMap) {
        T instance = null;
        try {
            Class<?> model = ((Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
            Constructor<?> constructor = model.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = (T) constructor.newInstance();
            Field[] modelFields = model.getDeclaredFields();
            for (Field field : modelFields) {
                String fieldName = field.getName();
                String columnName = StringUtil.camelToSnakeCase(fieldName);
                String setterMethodName = StringUtil.getGetterOrSetterString("set", columnName);
                Method setMethod = model.getDeclaredMethod(setterMethodName, field.getType());
                setMethod.setAccessible(true);
                invokeMethod(instance, setMethod, field.getType(), columnMap.get(columnName));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private void invokeMethod(T instance, Method method, Class<?> type, String value)
        throws InvocationTargetException, IllegalAccessException {
        if (type == String.class) {
            method.invoke(instance, value);
        } else if (type == Integer.class || type == int.class) {
            method.invoke(instance, Integer.parseInt(value));
        } else if (type == Date.class) {
            if (isUnixTimestamp(value)) {
                method.invoke(instance, new Date(Long.parseLong(value)));
            } else {
                method.invoke(instance, Date.valueOf(value));
            }
        } else if (type == Time.class) {
            method.invoke(instance, Time.valueOf(value));
        }
    }

    private static boolean isUnixTimestamp(String input) {
        try {
            long timestamp = Long.parseLong(input);
            // Assuming UNIX timestamp is in seconds, you may need to adjust if in milliseconds
            return timestamp >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
