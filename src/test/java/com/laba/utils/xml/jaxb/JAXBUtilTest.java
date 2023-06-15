package com.laba.utils.xml.jaxb;

import static org.testng.Assert.assertEquals;

import com.laba.models.Person;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class JAXBUtilTest {

    public static final String TEST_XML_OUT_DIR = "test/";

    @Test
    public void testMarshallOne() {
        Person p1 = new Person("Michael", "Scott", Date.valueOf("2000-01-01"));
        JAXBUtil.marshallOneXmlOut(p1, TEST_XML_OUT_DIR + "testPerson.xml");
    }

    @Test
    public void testMarshallManyXmlOut() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        Person p2 = new Person(2, "Michael2", "Scott", Date.valueOf("2000-01-01"));
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        JAXBUtil.marshallManyXmlOut(personList, TEST_XML_OUT_DIR + "testPersonList");
    }

    @Test
    public void testUnmarshall() {
        Person p1 = new Person("Michael", "Scott", Date.valueOf("2000-01-01"));
        String testFile = TEST_XML_OUT_DIR + "testPerson2.xml";
        JAXBUtil.marshallOneXmlOut(p1, testFile);
        File file = new File("export/xml/test/testPerson2.xml");
        Person p1Unmarshalled = (Person) JAXBUtil.unmarshallOne(Person.class, file);
        Object p1Unmarshalled2 = JAXBUtil.unmarshallOne(Person.class, file);

        assertEquals(p1, p1Unmarshalled);
        assertEquals(p1, p1Unmarshalled2);
    }
}