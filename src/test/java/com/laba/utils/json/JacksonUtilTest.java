package com.laba.utils.json;

import static com.laba.utils.AppConfig.jsonOutputDir;
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

    @Test
    public void testDbMapToJson() {
        JacksonUtil.dbMapToJson("db");
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
        String filename = "testP1";
        String outputDir = jsonOutputDir;
        File testFile = new File(outputDir + filename);
        if (testFile.exists()) {
            testFile.delete();
        }

        assertFalse(testFile.exists());
        List<Person> pList = new ArrayList<>();
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        Person p2 = new Person(2, "Michael2", "Scott", Date.valueOf("2000-01-01"));
        pList.add(p1);
        pList.add(p2);
        JacksonUtil.toJsonFile(pList, filename);
        assertTrue(new File(outputDir + filename + ".json").exists());
    }
};