package com.laba.jdbc;

import com.laba.models.Appointment;

public class AppointmentsDAO extends EntityDAO<Appointment> {

    @Override
    protected String getTableName() {
        return "appointments";
    }
}
