package com.laba.jdbc.mybatisDAOs;

import com.laba.interfaces.daos.IPersonDAO;
import com.laba.models.Person;
import java.sql.Date;

public class PersonMapper extends EntityMapper<Person> implements IPersonDAO {

    @Override
    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        return null;
    }
}
