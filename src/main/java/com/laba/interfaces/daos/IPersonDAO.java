package com.laba.interfaces.daos;

import com.laba.models.Person;
import java.sql.Date;

public interface IPersonDAO extends IEntityDAO<Person>{

    Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob);
}
