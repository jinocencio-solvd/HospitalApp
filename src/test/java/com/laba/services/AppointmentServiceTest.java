package com.laba.services;

import static org.testng.AssertJUnit.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.Appointment;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class AppointmentServiceTest {

    private final AppointmentService appointmentService;

    @Factory(dataProvider = "dataProvider")
    public AppointmentServiceTest(DaoType daoType) {
        appointmentService = new AppointmentService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
//            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetAppointmentsByPatientId() {
        List<Appointment> apptList = appointmentService.getAppointmentsByPatientId(1);
        assertEquals(apptList.size(), 4);

    }

}
