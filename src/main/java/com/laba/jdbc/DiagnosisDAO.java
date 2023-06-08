package com.laba.jdbc;

import com.laba.models.Diagnosis;

public class DiagnosisDAO extends EntityDAO<Diagnosis> {

    @Override
    protected String getTableName() {
        return "diagnosis";
    }

}
