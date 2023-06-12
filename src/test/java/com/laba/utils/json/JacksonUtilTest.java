package com.laba.utils.json;

import static com.laba.utils.AppConfig.jsonOutputDir;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import com.laba.models.Person;
import java.io.File;
import java.sql.Date;
import org.testng.annotations.Test;

public class JacksonUtilTest {

    @Test
    public void testToJsonString() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        String result = JacksonUtil.toJsonString(p1);
        String expected = "{\r\n  \"id\" : 1,\r\n  \"first_name\" : \"Michael1\",\r\n  \"last_name\" : \"Scott\",\r\n  \"dob\" : \"2000-01-01\"\r\n}";
        assertEquals(result, expected);
    }

    @Test
    public void testFromJsonString() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        String jsonString = JacksonUtil.toJsonString(p1);
        Person actual = JacksonUtil.fromJsonString(jsonString, new Person());
        assertEquals(actual, p1);
    }

    @Test
    public void testToJsonFile(){
        String filename = "testP1";
        String outputDir = jsonOutputDir;
        File testFile = new File(outputDir + filename);
        if(testFile.exists()){
            testFile.delete();
        }

        assertFalse(testFile.exists());
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        JacksonUtil.toJsonFile(p1, filename);
        assertTrue(new File(outputDir + filename+".json").exists());
    }
};