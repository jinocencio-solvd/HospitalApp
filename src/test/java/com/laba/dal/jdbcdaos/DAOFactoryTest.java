package com.laba.dal.jdbcdaos;

import static org.testng.Assert.*;

import com.laba.dal.DAOFactory;
import org.testng.annotations.Test;

public class DAOFactoryTest {

    @Test
    public void testGetDAO() {
        assertTrue( DAOFactory.getJDBCDAO("appointment") instanceof AppointmentDAO);
    }
}