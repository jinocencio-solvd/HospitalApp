package com.laba.jdbc;

import com.laba.model.Diagnosis;

public class DiagnosisDAO extends EntityDAO<Diagnosis> {

    @Override
    protected String getTableName() {
        return "diagnosis";
    }

}
