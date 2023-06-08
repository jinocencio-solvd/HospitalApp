package com.laba.jdbc;

import com.laba.models.MedicalRecord;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> {

    @Override
    protected String getTableName() {
        return "medical_records";
    }

}
