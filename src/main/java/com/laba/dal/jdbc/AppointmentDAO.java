package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.models.Appointment;

public class AppointmentDAO extends EntityDAO<Appointment> implements IAppointmentDAO {

    @Override
    protected String getTableName() {
        return "appointments";
    }
}
