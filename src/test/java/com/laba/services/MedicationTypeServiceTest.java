package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class MedicationTypeServiceTest {

    private final MedicationTypeService medicationTypeService;

    @Factory(dataProvider = "dataProvider")
    public MedicationTypeServiceTest(DaoType daoType) {
        medicationTypeService = new MedicationTypeService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetMedicationTypesByClinicianId() {
        int numListSize = medicationTypeService.getMedicationTypesByClinicianId(2).size();
        assertEquals(numListSize, 3);
    }

}