package com.laba.interfaces;

import com.laba.model.Person;
import java.sql.Date;

public interface IPersonDAO {
    Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob);
}
