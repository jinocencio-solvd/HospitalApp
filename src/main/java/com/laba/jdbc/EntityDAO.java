package com.laba.jdbc;

import com.laba.interfaces.IEntityDAO;
import com.laba.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class EntityDAO<T> implements IEntityDAO<T> {

    protected abstract String getTableName();

    protected abstract T createModelFromMap(Map<String, String> columnMap);

    protected abstract Map<String, Object> mapEntityToModelGetters(T entity);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<T> getAll() {
        Connection connection = connectionPool.getConnection();
        List<T> entityList = new ArrayList<>();
        Map<String, String> columnMap = new HashMap<>();

        String query = "SELECT * FROM " + getTableName();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    columnMap.put(columnName, rs.getString(columnName));
                }
                entityList.add(createModelFromMap(columnMap));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return entityList;
    }

    @Override
    public T getById(int id) {
        T entity = null;
        Connection connection = connectionPool.getConnection();
        Map<String, String> columnMap = new HashMap<>();
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?;";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    columnMap.put(columnName, rs.getString(columnName));
                }
                entity = createModelFromMap(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return entity;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?;";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    private String formatKeySetString(Set<String> keySet) {
        return keySet.toString()
            .replace("[", "(")
            .replace("]", ")");
    }


    @Override
    public void save(T entity) {
        Map<String, Object> entityMap = mapEntityToModelGetters(entity);
        Set<String> entityCols = entityMap.keySet();
        Connection connection = connectionPool.getConnection();
        String query =
            "INSERT INTO " + getTableName() + " " + formatKeySetString(entityCols) + " VALUES ("
                + "(?), ".repeat(entityCols.size() - 1) + "(?))";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            int idx = 1;
            for (String key : entityCols) {
                Object colValue = entityMap.get(key);
                if (colValue instanceof String) {
                    ps.setString(idx, (String) colValue);
                } else if (colValue instanceof Integer) {
                    ps.setInt(idx, (Integer) colValue);
                } else if (colValue instanceof Date) {
                    ps.setDate(idx, (Date) colValue);
                }
                idx++;
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        Map<String, Object> entityMap = mapEntityToModelGetters(entity);
        Set<String> entityCols = entityMap.keySet();
        Connection connection = connectionPool.getConnection();

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE ").append(getTableName()).append(" SET ");
        for (String col : entityCols) {
            queryBuilder.append(col).append(" = ?, ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
        queryBuilder.append(" WHERE id = ?");

        String query = queryBuilder.toString();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            int idx = 1;
            for (String key : entityCols) {
                Object colValue = entityMap.get(key);
                if (colValue instanceof String) {
                    ps.setString(idx, (String) colValue);
                } else if (colValue instanceof Integer) {
                    ps.setInt(idx, (Integer) colValue);
                } else if (colValue instanceof Date) {
                    ps.setDate(idx, (Date) colValue);
                }
                idx++;
            }
            ps.setInt(idx, (Integer) entityMap.get("id") );
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
