package com.laba.dal.jdbc;

import static org.testng.Assert.*;

import com.laba.models.Person;
import java.sql.Date;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonDAOTest {

    private static PersonDAO personDAO;

    @BeforeMethod
    public void setUp() {
        personDAO = new PersonDAO();
    }

    @AfterMethod
    public void tearDown() {
        List<Person> getAllPerson = personDAO.getAll();
        getAllPerson.forEach((p) -> personDAO.deleteById(p.getId()));
    }

    @Test
    public void testGetByFirstLastNameAndDob() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        Person retPerson = personDAO.getByFirstLastNameAndDob(p1.getFirstName(), p1.getLastName(),
            p1.getDob());
        assertEquals(p1, retPerson);
    }
}