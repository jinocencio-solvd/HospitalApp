package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class StaffServiceTest {

    private final StaffService staffService;

    @Factory(dataProvider = "dataProvider")
    public StaffServiceTest(DaoType daoType) {
        staffService = new StaffService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetStaffByDepartmentId() {
        int numStaff = staffService.getStaffByDepartmentId(2).size();
        assertEquals(numStaff, 3);
    }

}