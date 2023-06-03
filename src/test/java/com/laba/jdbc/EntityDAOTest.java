package com.laba.jdbc;

import static org.testng.Assert.*;

import com.laba.model.Person;
import java.sql.Date;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EntityDAOTest {

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
    public void testSave() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        personDAO.save(p2);
        Person retrievedPerson1 = personDAO.getAll().get(0);
        assertEquals(p1, retrievedPerson1);
        assertNotEquals(p2, retrievedPerson1);
    }

    @Test
    public void testGetAll() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personDAO.save(p1);
        personDAO.save(p2);
        personDAO.save(p3);
        List<Person> getAllPerson = personDAO.getAll();
        assertEquals(3, getAllPerson.size());
    }

    @Test
    public void testGetById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        Person retrievedPerson = personDAO.getAll().get(0);
        int id = retrievedPerson.getId();
        assertEquals(p1, personDAO.getById(id));
    }

    @Test
    public void testDeleteById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personDAO.save(p1);
        personDAO.save(p2);
        personDAO.save(p3);
        Person retrievedPerson1 = personDAO.getAll().get(0);
        Person retrievedPerson2 = personDAO.getAll().get(1);
        personDAO.deleteById(retrievedPerson1.getId());
        personDAO.deleteById(retrievedPerson2.getId());
        assertEquals(1, personDAO.getAll().size());
    }

    @Test
    public void testUpdate() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        Person retrievedPerson1 = personDAO.getAll().get(0);
        retrievedPerson1.setFirstName("newp1LastName");
        personDAO.update(retrievedPerson1);
        assertNotEquals(retrievedPerson1, p1);
        Person updatedRetrievedPerson1 = personDAO.getAll().get(0);
        assertEquals(retrievedPerson1, updatedRetrievedPerson1);
        assertNotEquals(updatedRetrievedPerson1, p1);
    }
}