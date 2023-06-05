package com.laba.services;

import static org.testng.Assert.*;

import com.laba.models.Person;
import java.sql.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonServiceTest {

    private static PersonService personService;
    private static final boolean isSingleThreaded = true;

    @BeforeMethod
    public void setUp() {
        personService = new PersonService();
    }

    @AfterMethod
    public void tearDown() {
        List<Person> getAllPerson = personService.getAll();
        getAllPerson.forEach((p) -> personService.deleteById(p.getId()));
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testSave() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        personService.save(p2);
        Person retrievedPerson1 = personService.getAll().get(0);
        assertEquals(p1, retrievedPerson1);
        assertNotEquals(p2, retrievedPerson1);
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testGetAll() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personService.save(p1);
        personService.save(p2);
        personService.save(p3);
        List<Person> getAllPerson = personService.getAll();
        assertEquals(3, getAllPerson.size());
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testGetById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        Person retrievedPerson = personService.getAll().get(0);
        int id = retrievedPerson.getId();
        assertEquals(p1, personService.getById(id));
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testDeleteById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personService.save(p1);
        personService.save(p2);
        personService.save(p3);
        Person retrievedPerson1 = personService.getAll().get(0);
        Person retrievedPerson2 = personService.getAll().get(1);
        personService.deleteById(retrievedPerson1.getId());
        personService.deleteById(retrievedPerson2.getId());
        assertEquals(1, personService.getAll().size());
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testUpdate() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        Person retrievedPerson1 = personService.getAll().get(0);
        retrievedPerson1.setFirstName("newp1LastName");
        personService.update(retrievedPerson1);
        assertNotEquals(retrievedPerson1, p1);
        Person updatedRetrievedPerson1 = personService.getAll().get(0);
        assertEquals(retrievedPerson1, updatedRetrievedPerson1);
        assertNotEquals(updatedRetrievedPerson1, p1);
    }

}