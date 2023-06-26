package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.models.Appointment;
import java.util.List;

public class AppointmentService extends EntityService<Appointment, IAppointmentDAO> implements
    IAppointmentDAO {

    public AppointmentService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "appointment";
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return dao.getAppointmentsByPatientId(patientId);
    }

}
