package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DiagnosisServiceTest {

    private final DiagnosisService diagnosisService;

    @Factory(dataProvider = "dataProvider")
    public DiagnosisServiceTest(DaoType daoType) {
        diagnosisService = new DiagnosisService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetDiagnosisByDiagnosisId() {
        int numDiagnosisByDept = diagnosisService.getDiagnosisByDepartmentId(3).size();
        assertEquals(numDiagnosisByDept, 3);
    }

}