package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.models.Appointment;
import java.util.List;

public class AppointmentDAO extends EntityDAO<Appointment> implements IAppointmentDAO {

    @Override
    protected String getTableName() {
        return "appointments";
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        // TODO: impl JDBC meethod
        return null;
    }
}
