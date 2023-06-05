package com.laba.jdbc;

import static org.testng.Assert.*;

import com.laba.models.Person;
import java.lang.reflect.Constructor;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EntityDAOTest {

    private static PersonDAO personDAO;
    private static final boolean isSingleThreaded = true;
    @BeforeMethod
    public void setUp() {
        personDAO = new PersonDAO();
    }

    @AfterMethod
    public void tearDown() {
        List<Person> getAllPerson = personDAO.getAll();
        getAllPerson.forEach((p) -> personDAO.deleteById(p.getId()));
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testSave() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        personDAO.save(p2);
        Person retrievedPerson1 = personDAO.getAll().get(0);
        assertEquals(p1, retrievedPerson1);
        assertNotEquals(p2, retrievedPerson1);
    }

    @Test(singleThreaded = isSingleThreaded)
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

    @Test(singleThreaded = isSingleThreaded)
    public void testGetById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personDAO.save(p1);
        Person retrievedPerson = personDAO.getAll().get(0);
        int id = retrievedPerson.getId();
        assertEquals(p1, personDAO.getById(id));
    }

    @Test(singleThreaded = isSingleThreaded)
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

    @Test(singleThreaded = isSingleThreaded)
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

    @Test(singleThreaded = isSingleThreaded)
    public void testGetWildTypeConstructor() throws NoSuchMethodException {
        Constructor<?> expected = Person.class.getConstructor();
        Constructor<?> p = personDAO.getWildTypeConstructor();
        assertEquals(expected,p);
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testMapColumnNamesToModelGetters1(){
        Person p = new Person(22,"first", "last", Date.valueOf("1990-09-21"));
        String expected = "{id=22, first_name=first, last_name=last, dob=1990-09-21}";
        assertEquals(personDAO.mapColumnNamesToModelGetters(p).toString(), expected);
    }

    @Test(singleThreaded = isSingleThreaded)
    public void testCreateModelFromMap1(){
        Map<String, String> columnMap = new HashMap<>();
        Person p = new Person(22,"first", "last", Date.valueOf("1990-09-21"));
        columnMap.put("id", p.getId().toString());
        columnMap.put("first_name", p.getFirstName());
        columnMap.put("last_name", p.getLastName());
        columnMap.put("dob", p.getDob().toString());

        int id = Integer.parseInt(columnMap.get("id"));
        String firstName = columnMap.get("first_name");
        String lastName = columnMap.get("last_name");
        Date dob = Date.valueOf(columnMap.get("dob"));
        Person p1 = new Person(id, firstName, lastName, dob);
        assertEquals(p, p1);
        assertEquals(personDAO.createModelFromMap(columnMap), p);
    }
}