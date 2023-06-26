package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DepartmentServiceTest {

    private final DepartmentService departmentService;

    @Factory(dataProvider = "dataProvider")
    public DepartmentServiceTest(DaoType daoType) {
        departmentService = new DepartmentService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetDepartmentsByDepartmentId() {
        int numDeptByClinicianId = departmentService.getDepartmentsByClinicianId(1).size();
        assertEquals(numDeptByClinicianId, 5);
    }

}