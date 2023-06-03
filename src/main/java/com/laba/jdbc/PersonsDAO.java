package com.laba.jdbc;


import com.laba.interfaces.IEntityDAO;
import com.laba.model.Persons;

public class PersonsDAO extends EntityDAO<Persons> {

    @Override
    protected String getTableName() {
        return "persons";
    }
}
