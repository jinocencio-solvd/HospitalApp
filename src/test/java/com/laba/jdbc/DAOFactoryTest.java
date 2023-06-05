package com.laba.jdbc;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DAOFactoryTest {

    @Test
    public void testGetDAO() {
        assertTrue( DAOFactory.getDAO("appointment") instanceof AppointmentDAO);
    }
}