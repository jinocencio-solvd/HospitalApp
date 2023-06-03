package com.laba.jdbc;

import com.laba.model.Persons;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersonsDAO extends EntityDAO<Persons> {

    @Override
    protected String getTableName() {
        return "persons";
    }

    @Override
    protected Persons createModelFromMap(Map<String, String> columnMap) {
        Integer id = Integer.valueOf(columnMap.get("id"));
        String firstName = columnMap.get("first_name");
        String lastName = columnMap.get("last_name");
        Date dob = Date.valueOf(columnMap.get("dob"));
        return new Persons(id, firstName, lastName, dob);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Persons entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("first_name", entity.getFirstName());
        getters.put("last_name", entity.getLastName());
        getters.put("dob", entity.getDob());
        return getters;
    }
}
