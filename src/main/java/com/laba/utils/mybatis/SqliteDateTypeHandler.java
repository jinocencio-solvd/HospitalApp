package com.laba.utils.mybatis;

import com.laba.enums.DatabaseType;
import com.laba.utils.AppConfig;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqliteDateTypeHandler extends BaseTypeHandler<Date> {

    private static final Logger LOG = LogManager.getLogger(SqliteDateTypeHandler.class);
    private static DatabaseType dbType;

    static {
        if (AppConfig.ENVIRONMENT.equals("DEVELOPMENT")) {
            dbType = DatabaseType.MYSQL;
        }
        if (AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")) {
            dbType = DatabaseType.SQLITE;
        }
    }


    public boolean hasColumn(ResultSet resultSet, String columnName) {
        try {
            resultSet.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date,
        JdbcType jdbcType) throws SQLException {
        LOG.debug("Handling SQLiteDateSetter date: " + date.toString());
        if (dbType == DatabaseType.SQLITE) {
            String dateString = date.toString();
            preparedStatement.setString(i, dateString);
        } else {
            preparedStatement.setDate(i, date);
        }

    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String dateStr = "";
        if (hasColumn(resultSet, "dob")) {
            dateStr = resultSet.getString("dob");
        }
        return Date.valueOf((dateStr));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println(2);
        return resultSet.getDate(i);
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println(3);
        return callableStatement.getDate(i);
    }
}
