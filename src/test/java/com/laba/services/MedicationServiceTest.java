package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class MedicationServiceTest {

    private final MedicationService medicationService;

    @Factory(dataProvider = "dataProvider")
    public MedicationServiceTest(DaoType daoType) {
        medicationService = new MedicationService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetMedicationsByPatientId() {
        int numMedicationByDept = medicationService.getMedicationsByPatientId(2).size();
        assertEquals(numMedicationByDept, 2);
    }

}