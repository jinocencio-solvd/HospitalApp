package com.laba.jdbc;

import com.laba.model.Appointment;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.Map;

public class AppointmentsDAO extends EntityDAO<Appointment> {

    @Override
    protected String getTableName() {
        return "appointments";
    }

    @Override
    protected Appointment createModelFromMap(Map<String, String> columnMap) {
        int patientId = Integer.parseInt(columnMap.get("patient_id"));
        int clinicianId = Integer.parseInt(columnMap.get("clinician_id"));
        int roomId = Integer.parseInt(columnMap.get("room_id"));
        Date date = Date.valueOf(columnMap.get("appointment_date"));
        Time time = Time.valueOf(columnMap.get("appointment_time"));
        return new Appointment(patientId, clinicianId, roomId, date, time);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Appointment entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("patient_id", entity.getPatientId());
        getters.put("clinician_id", entity.getClinicianId());
        getters.put("room_id", entity.getRoomId());
        getters.put("appointment_date", entity.getDate());
        getters.put("appointment_time", entity.getTime());
        return getters;
    }
}
