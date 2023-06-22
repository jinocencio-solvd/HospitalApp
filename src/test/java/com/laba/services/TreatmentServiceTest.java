package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.utils.AppUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TreatmentServiceTest {

    private final TreatmentService treatmentService;

    @BeforeClass
    public void before() {
        AppUtils.populateDB();
    }

    @Factory(dataProvider = "dataProvider")
    public TreatmentServiceTest(DaoType daoType) {
        treatmentService = new TreatmentService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetTreatmentsByPatientId() {
        int numTreatmentsOnPatient = treatmentService.getTreatmentsByPatientId(1).size();
        assertEquals(numTreatmentsOnPatient, 7);
    }

}