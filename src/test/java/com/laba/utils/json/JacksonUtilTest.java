package com.laba.utils.json;

import static org.testng.Assert.assertEquals;

import com.laba.models.Person;
import java.sql.Date;
import org.testng.annotations.Test;

public class JacksonUtilTest {

    @Test
    public void testToJson() {
        Person p1 = new Person(1, "Michael1", "Scott", Date.valueOf("2000-01-01"));
        String result = JacksonUtil.toJsonString(p1);
        String expected = "{\r\n  \"id\" : 1,\r\n  \"first_name\" : \"Michael1\",\r\n  \"last_name\" : \"Scott\",\r\n  \"dob\" : \"2000-01-01\"\r\n}";
        assertEquals(result, expected);
    }
};