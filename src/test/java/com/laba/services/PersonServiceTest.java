package com.laba.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import com.laba.enums.DaoType;
import com.laba.models.Person;
import java.sql.Date;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PersonServiceTest {

    private static PersonService personService;

    @Factory(dataProvider = "dataProvider")
    public PersonServiceTest(DaoType daoType) {
        personService = new PersonService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testSave() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        personService.save(p1);
        personService.save(p2);
        Person retrievedPerson1 = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        Person retrievedPerson2 = personService.getByFirstLastNameAndDob(p2.getFirstName(),
            p2.getLastName(), p2.getDob());
        assertEquals(p1, retrievedPerson1);
        assertEquals(p2, retrievedPerson2);
        assertNotEquals(retrievedPerson1, retrievedPerson2);
        personService.deleteById(retrievedPerson1.getId());
        personService.deleteById(retrievedPerson2.getId());
    }

    @Test
    public void testGetAll() {
        int preCount = personService.getAll().size();
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personService.save(p1);
        personService.save(p2);
        personService.save(p3);
        assertEquals(personService.getAll().size(), preCount + 3);
        Person retrievedPerson1 = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        Person retrievedPerson2 = personService.getByFirstLastNameAndDob(p2.getFirstName(),
            p2.getLastName(), p2.getDob());
        Person retrievedPerson3 = personService.getByFirstLastNameAndDob(p3.getFirstName(),
            p3.getLastName(), p3.getDob());
        personService.deleteById(retrievedPerson1.getId());
        personService.deleteById(retrievedPerson2.getId());
        personService.deleteById(retrievedPerson3.getId());
        assertEquals(preCount, personService.getAll().size());
    }

    @Test
    public void testGetById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        Person retrievedPerson = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        int id = retrievedPerson.getId();
        assertEquals(p1, personService.getById(id));
        personService.deleteById(retrievedPerson.getId());
    }

    @Test
    public void testDeleteById() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        Person p2 = new Person("p2First", "p2Last", Date.valueOf("2002-02-02"));
        Person p3 = new Person("p3First", "p3Last", Date.valueOf("2003-03-03"));
        personService.save(p1);
        personService.save(p2);
        personService.save(p3);
        int curSize = personService.getAll().size();
        Person retrievedPerson1 = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        Person retrievedPerson2 = personService.getByFirstLastNameAndDob(p2.getFirstName(),
            p2.getLastName(), p2.getDob());
        Person retrievedPerson3 = personService.getByFirstLastNameAndDob(p3.getFirstName(),
            p3.getLastName(), p3.getDob());
        personService.deleteById(retrievedPerson1.getId());
        personService.deleteById(retrievedPerson2.getId());
        assertEquals(curSize - 2, personService.getAll().size());
        personService.deleteById(retrievedPerson3.getId());
    }

    @Test
    public void testUpdate() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        Person retrievedPerson1 = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        retrievedPerson1.setFirstName("newp1LastName");
        personService.update(retrievedPerson1);
        assertNotEquals(retrievedPerson1, p1);
        Person updatedRetrievedPerson1 = personService.getByFirstLastNameAndDob(
            retrievedPerson1.getFirstName(),
            retrievedPerson1.getLastName(), retrievedPerson1.getDob());
        assertEquals(retrievedPerson1, updatedRetrievedPerson1);
        assertNotEquals(updatedRetrievedPerson1, p1);
        personService.deleteById(retrievedPerson1.getId());
    }

    @Test
    public void testGetByFirstLastNameAndDob() {
        Person p1 = new Person("p1First", "p1Last", Date.valueOf("2001-01-01"));
        personService.save(p1);
        Person retPerson = personService.getByFirstLastNameAndDob(p1.getFirstName(),
            p1.getLastName(), p1.getDob());
        assertEquals(p1, retPerson);
        personService.deleteById(retPerson.getId());

    }

}