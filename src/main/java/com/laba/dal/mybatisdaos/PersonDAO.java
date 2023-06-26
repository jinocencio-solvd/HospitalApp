package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IPersonDAO;
import com.laba.models.Person;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonDAO extends EntityDAO<Person> implements IPersonDAO {

    @Override
    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("dob", dob);
        return session.selectOne(getNamespace() + ".getByFirstLastNameAndDob", parameters);
    }
}
