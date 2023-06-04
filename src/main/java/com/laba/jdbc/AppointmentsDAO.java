package com.laba.jdbc;

import com.laba.model.Appointment;

public class AppointmentsDAO extends EntityDAO<Appointment> {

    @Override
    protected String getTableName() {
        return "appointments";
    }
}
