package com.laba.jdbc;

import com.laba.interfaces.IEntityDAO;
import com.laba.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntityDAO<T> implements IEntityDAO<T> {

    protected abstract String getTableName();

    protected abstract T createModelFromMap(Map<String, String> columnMap);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<T> getAll() {
        Connection connection = connectionPool.getConnection();
        List<T> entityList = new ArrayList<>();
        Map<String, String> columnMap = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + getTableName());
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

//    @Override
//    public T getById(int id) {
//        return null;
//    }
//
//
//    @Override
//    public void save(T entity) {
//
//    }
//
//    @Override
//    public void update(T entity) {
//
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
}
