package com.laba.utils.xml.jaxb;

import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.text.SimpleDateFormat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DateAdapterTest {

    DateAdapter dateAdapter;

    @BeforeMethod
    public void setUp() {
        dateAdapter = new DateAdapter();
    }

    @Test
    public void testUnmarshal() throws Exception {
        String dateString = "2023-06-10";
        Date expectedDate = new Date(new SimpleDateFormat("yyyy-MM-dd")
            .parse(dateString).getTime());
        Date date = dateAdapter.unmarshal(dateString);
        assertEquals(date, expectedDate);
    }

    @Test
    public void testMarshal() {
        long sqlDateLong = System.currentTimeMillis();
        Date sqlDate = new Date(sqlDateLong);
        String marshalledDate = dateAdapter.marshal(sqlDate);
        assertEquals(sqlDate.toString(), marshalledDate);
    }
}