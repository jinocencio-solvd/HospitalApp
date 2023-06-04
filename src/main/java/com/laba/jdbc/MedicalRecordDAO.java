package com.laba.jdbc;

import com.laba.model.MedicalRecord;
import java.util.LinkedHashMap;
import java.util.Map;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> {

    @Override
    protected String getTableName() {
        return "medical_records";
    }

    @Override
    protected MedicalRecord createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        int appointmentId = Integer.parseInt(columnMap.get("appointment_id"));
        int diagnosisId = Integer.parseInt(columnMap.get("diagnosis_id"));
        int treatmentId = Integer.parseInt(columnMap.get("treatment_id"));
        return new MedicalRecord(id, appointmentId, diagnosisId, treatmentId);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(MedicalRecord entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("appointment_id", entity.getAppointmentId());
        getters.put("diagnosis_id", entity.getDiagnosisId());
        getters.put("treatment_id", entity.getTreatmentId());
        return getters;
    }
}
