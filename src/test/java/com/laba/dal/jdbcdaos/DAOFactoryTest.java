package com.laba.dal.jdbcdaos;

import static org.testng.Assert.assertTrue;

import com.laba.dal.daofactories.DAOFactoryGenerator;
import com.laba.enums.DaoType;
import org.testng.annotations.Test;

public class DAOFactoryTest {

    @Test
    public void testGetDAO() {
        assertTrue(DAOFactoryGenerator.getFactory(DaoType.JDBC)
            .getDAO("appointment") instanceof AppointmentDAO);
    }

}