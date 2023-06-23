package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PrescriptionServiceTest {

    private final PrescriptionService prescriptionService;

    @Factory(dataProvider = "dataProvider")
    public PrescriptionServiceTest(DaoType daoType) {
        prescriptionService = new PrescriptionService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetPrescriptionsByPatientId() {
        int numPrescriptionsForPatient = prescriptionService.getPrescriptionsByPatientId(2).size();
        assertEquals(numPrescriptionsForPatient, 3);
    }

}