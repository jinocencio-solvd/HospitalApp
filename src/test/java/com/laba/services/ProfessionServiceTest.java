package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ProfessionServiceTest {

    private final ProfessionService professionService;

    @Factory(dataProvider = "dataProvider")
    public ProfessionServiceTest(DaoType daoType) {
        professionService = new ProfessionService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetProfessionByDepartmentId() {
        int numProfessionsByDepartment = professionService.getProfessionByDepartmentId(3).size();
        assertEquals(numProfessionsByDepartment, 3);
    }

}