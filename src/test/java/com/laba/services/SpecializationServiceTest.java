package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.utils.AppUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SpecializationServiceTest {

    private final SpecializationService specializationService;

    @BeforeClass
    public void before() {
        AppUtils.populateDB();
    }

    @Factory(dataProvider = "dataProvider")
    public SpecializationServiceTest(DaoType daoType) {
        specializationService = new SpecializationService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetSpecializationByClinicianId() {
        String specialization = specializationService.getSpecializationByClinicianId(3)
            .getSpecialization();
        assertEquals(specialization, "General Medicine");
    }

}