package com.laba.jdbc;

import com.laba.interfaces.IEntityDAO;
import com.laba.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class EntityDAO<T> implements IEntityDAO<T> {

    protected abstract String getTableName();

    private final Connection connection = ConnectionPool.getInstance().getConnection();

    @Override
    public List<T> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + getTableName());
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
