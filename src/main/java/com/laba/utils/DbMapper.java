package com.laba.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class DbMapper {

    public static final String interfaceLoc = "com.laba.interfaces.daos.";
    public static final String modelLoc = "com.laba.models.";

    private static final Map<String, String> personPropColMap = new LinkedHashMap<>();
    private static final Map<String, String> appointmentPropColMap = new LinkedHashMap<>();

    public static Map<String, Map<String, String>> getPropertyColumnMap() {
        Map<String, Map<String, String>> propColMap = new LinkedHashMap<>();
        propColMap.put("person", personPropColMap);
        propColMap.put("appointment", appointmentPropColMap);
        return propColMap;
    }

    static {
        personPropColMap.put("type", modelLoc + "Person");
        personPropColMap.put("namespace", interfaceLoc + "IPersonDAO");
        personPropColMap.put("table_name", "persons");
        personPropColMap.put("field_id", "id");
        personPropColMap.put("field_firstName", "first_name");
        personPropColMap.put("field_lastName", "last_name");
        personPropColMap.put("field_dob", "dob");

        appointmentPropColMap.put("type", modelLoc + "Appointment");
        appointmentPropColMap.put("namespace", interfaceLoc + "IAppointmentDAO");
        appointmentPropColMap.put("table_name", "appointments");
        appointmentPropColMap.put("field_id", "id");
        appointmentPropColMap.put("field_patientId", "patient_id");
        appointmentPropColMap.put("field_clinicianId", "clinician_id");
        appointmentPropColMap.put("field_roomId", "room_id");
        appointmentPropColMap.put("field_date", "appointment_date");
        appointmentPropColMap.put("field_time", "appointment_time");
    }
}
