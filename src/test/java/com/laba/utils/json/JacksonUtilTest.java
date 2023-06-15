package com.laba.utils.json;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import com.laba.models.Person;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class JacksonUtilTest {

    public static final String TEST_JSON_OUT_DIR = "/test";

    @Test
    public void testDbMapToJson() {
        JacksonUtil.dbMapToJson(TEST_JSON_OUT_DIR+"/"+"db");
        assertTrue(new File("export/json/test/db.json").exists());
    }

    @Test
    public void testToJsonString() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        String result = JacksonUtil.toJsonString(p1);
        assertTrue(result.contains("first_name") && result.contains(p1.getFirstName()));
        assertTrue(result.contains("dob") && result.contains(p1.getDob().toString()));
    }

    @Test
    public void testFromJsonString() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        String jsonString = JacksonUtil.toJsonString(p1);
        Person actual = JacksonUtil.fromJsonString(jsonString, new Person());
        assertEquals(actual, p1);
    }

    @Test
    public void testToJsonFile() {
        String filepath = TEST_JSON_OUT_DIR + "/" + "testP1";
        File testFile = new File(filepath);
        if (testFile.exists()) {
            testFile.delete();
        }
        assertFalse(testFile.exists());
        List<Person> pList = new ArrayList<>();
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        Person p2 = new Person(2, "Michael2", "Scott", Date.valueOf("2000-01-01"));
        pList.add(p1);
        pList.add(p2);
        JacksonUtil.toJsonFile(pList, filepath);
        assertTrue(new File("export/json/test/testP1.json").exists());
    }
};