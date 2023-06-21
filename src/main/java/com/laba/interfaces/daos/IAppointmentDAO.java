package com.laba.interfaces.daos;

import com.laba.models.Appointment;
import java.util.List;

public interface IAppointmentDAO extends IEntityDAO<Appointment> {

    List<Appointment> getAppointmentsByPatientId(int patientId);
}
