package com.laba.utils.mybatis;

import com.laba.enums.DatabaseType;
import com.laba.utils.AppConfig;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqliteTimeTypeHandler extends BaseTypeHandler<Time> {

    private static final Logger LOG = LogManager.getLogger(SqliteTimeTypeHandler.class);
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
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Time time,
        JdbcType jdbcType) throws SQLException {
        LOG.debug("Handling SQLiteTimeSetter time: " + time.toString());
        if (dbType == DatabaseType.SQLITE) {
            String timeString = time.toString();
            preparedStatement.setString(i, timeString);
        } else {
            preparedStatement.setTime(i, time);
        }
    }

    @Override
    public Time getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        if (hasColumn(resultSet, columnName)) {
            String timeStr = resultSet.getString(columnName);
            return Time.valueOf(timeStr);
        }
        return null;
    }

    @Override
    public Time getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getTime(columnIndex);
    }

    @Override
    public Time getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return callableStatement.getTime(columnIndex);
    }
}
