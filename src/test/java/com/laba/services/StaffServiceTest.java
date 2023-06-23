package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.models.Staff;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class StaffServiceTest {

    private final StaffService staffService;
    private static PersonService personService;

    @Factory(dataProvider = "dataProvider")
    public StaffServiceTest(DaoType daoType) {
        staffService = new StaffService(daoType);
        personService = new PersonService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetStaffByPersonId() {
        Person person = personService.getById(14);
        Staff staff = staffService.getStaffByPersonId(person.getId());
        assertEquals(staff.getPerson().getId(), person.getId());
        assertEquals(staff.getPerson(), person);
    }

    @Test
    public void testGetStaffByDepartmentId() {
        int numStaff = staffService.getStaffByDepartmentId(2).size();
        assertEquals(numStaff, 3);
    }

}