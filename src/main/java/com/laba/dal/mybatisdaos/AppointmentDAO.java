package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.models.Appointment;
import java.util.List;

public class AppointmentDAO extends EntityDAO<Appointment> implements IAppointmentDAO {

    @Override
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return session.selectList(getNamespace() + ".getAppointmentsByPatientId", patientId);
    }
}
