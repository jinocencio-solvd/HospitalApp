package com.laba.jdbc;

import com.laba.model.MedicalRecord;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> {

    @Override
    protected String getTableName() {
        return "medical_records";
    }

}
