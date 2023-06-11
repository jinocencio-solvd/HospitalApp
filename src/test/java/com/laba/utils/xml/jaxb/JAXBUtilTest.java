package com.laba.utils.xml.jaxb;

import static com.laba.utils.AppConfig.xmlOutputDir;
import static org.testng.Assert.assertEquals;

import com.laba.models.Person;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JAXBUtilTest {

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void testMarshallOne() {
        Person p1 = new Person("Michael", "Scott", Date.valueOf("2000-01-01"));
        JAXBUtil.marshallOneXmlOut(p1);
    }

    @Test
    public void testMarshallManyXmlOut() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        Person p2 = new Person(2, "Michael2", "Scott", Date.valueOf("2000-01-01"));
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        JAXBUtil.marshallManyXmlOut(personList);
    }

    @Test
    public void testUnmarshallMode() {
        Person p1 = new Person("Michael", "Scott", Date.valueOf("2000-01-01"));
        JAXBUtil.marshallOneXmlOut(p1);
        String path = xmlOutputDir + "Person.xml";
        File file = new File(path);
        Person p1Unmarshalled = (Person) JAXBUtil.unmarshallOne(file, Person.class);
        Object p1Unmarshalled2 = JAXBUtil.unmarshallOne(file, Person.class);

        assertEquals(p1, p1Unmarshalled);
        assertEquals(p1, p1Unmarshalled2);
    }
}