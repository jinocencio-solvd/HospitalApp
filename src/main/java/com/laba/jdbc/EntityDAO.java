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
        String query = "SELECT * FROM " + getTableName();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entityList.add(getEntity(rs));
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
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?;";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entity = getEntity(rs);
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

    private int prepareStatement(PreparedStatement ps, Map<String, Object> entityMap)
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
            }
            idx++;
        }
        return idx;
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
            prepareStatement(ps, entityMap);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    private String queryBuilder(T entity) {
        Map<String, Object> entityMap = mapEntityToModelGetters(entity);

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
        Map<String, Object> entityMap = mapEntityToModelGetters(entity);
        Connection connection = connectionPool.getConnection();
        String query = queryBuilder(entity);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            int idx = prepareStatement(ps, entityMap);
            ps.setInt(idx, (Integer) entityMap.get("id"));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }
}
