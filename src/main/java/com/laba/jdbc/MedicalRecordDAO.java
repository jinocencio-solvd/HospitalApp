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
}
