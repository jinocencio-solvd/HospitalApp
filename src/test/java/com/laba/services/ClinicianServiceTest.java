package com.laba.services;

import static org.testng.AssertJUnit.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.Clinician;
import com.laba.utils.AppUtils;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ClinicianServiceTest {

    private final ClinicianService clinicianService;

    @BeforeClass
    public void before() {
        AppUtils.populateDB();
    }

    @Factory(dataProvider = "dataProvider")
    public ClinicianServiceTest(DaoType daoType) {
        clinicianService = new ClinicianService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetCliniciansByDepartmentId() {
        List<Clinician> cliniciansByDept = clinicianService.getCliniciansByDepartmentId(2);
        assertEquals(cliniciansByDept.size(), 3);
    }

}