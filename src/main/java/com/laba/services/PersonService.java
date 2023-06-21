package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPersonDAO;
import com.laba.models.Person;
import java.sql.Date;

public class PersonService extends EntityService<Person, IPersonDAO> implements IPersonDAO {

    public PersonService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "person";
    }

    @Override
    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        return dao.getByFirstLastNameAndDob(firstName, lastName, dob);
    }

}
