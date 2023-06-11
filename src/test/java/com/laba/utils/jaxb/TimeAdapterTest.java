package com.laba.utils.jaxb;

import static org.testng.AssertJUnit.assertEquals;

import java.sql.Time;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeAdapterTest {

    TimeAdapter timeAdapter;

    @BeforeMethod
    public void setUp() {
        timeAdapter = new TimeAdapter();
    }

    @Test
    public void testUnmarshal() throws Exception {
        String timeString = "12:34:00";
        Time testTime = timeAdapter.unmarshal(timeString);
        Time expected = Time.valueOf(timeString);
        assertEquals(testTime, expected);
    }

    @Test
    public void testMarshal() throws Exception {
        String expectedString = "12:34:00";
        Time expected = Time.valueOf(expectedString);
        String testString = timeAdapter.marshal(expected);
        assertEquals(testString, expectedString);
    }
}