package com.laba.jdbc;

import com.laba.interfaces.IPersonDAO;
import com.laba.model.Person;
import com.laba.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersonDAO extends EntityDAO<Person> implements IPersonDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    protected String getTableName() {
        return "persons";
    }

    @Override
    protected Person createModelFromMap(Map<String, String> columnMap) {
        Integer id = Integer.parseInt(columnMap.get("id"));
        String firstName = columnMap.get("first_name");
        String lastName = columnMap.get("last_name");
        Date dob = Date.valueOf(columnMap.get("dob"));
        return new Person(id, firstName, lastName, dob);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Person entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("first_name", entity.getFirstName());
        getters.put("last_name", entity.getLastName());
        getters.put("dob", entity.getDob());
        return getters;
    }

    @Override
    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        Person person = null;
        Map<String, String> columnMap = new LinkedHashMap<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM " + getTableName()
            + " WHERE first_name = ? AND last_name = ? AND dob = ?;";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDate(3, dob);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    columnMap.put(columnName, rs.getString(columnName));
                }
                person = createModelFromMap(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return person;
    }
}