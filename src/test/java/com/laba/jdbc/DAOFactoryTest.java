package com.laba.jdbc;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class DAOFactoryTest {

    @Test
    public void testGetDAO() {
        assertTrue( DAOFactory.getJDBCDAO("appointment") instanceof AppointmentDAO);
    }
}