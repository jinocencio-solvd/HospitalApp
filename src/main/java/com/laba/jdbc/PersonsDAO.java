package com.laba.jdbc;

import com.laba.model.Persons;
import java.sql.Date;
import java.util.Map;

public class PersonsDAO extends EntityDAO<Persons> {

    @Override
    protected String getTableName() {
        return "persons";
    }

    @Override
    protected Persons createModelFromMap(Map<String, String> columnMap) {
        String firstName = columnMap.get("first_name");
        String lastName = columnMap.get("last_name");
        Date dob = Date.valueOf(columnMap.get("dob"));
        return new Persons(firstName, lastName, dob);
    }
}
