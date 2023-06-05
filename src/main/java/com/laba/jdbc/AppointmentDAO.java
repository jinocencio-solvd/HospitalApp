package com.laba.jdbc;

import com.laba.models.Appointment;

public class AppointmentDAO extends EntityDAO<Appointment> {

    @Override
    protected String getTableName() {
        return "appointments";
    }
}
