package com.laba.jdbc;

import com.laba.model.Diagnosis;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiagnosisDAO extends EntityDAO<Diagnosis> {

    @Override
    protected String getTableName() {
        return "diagnosis";
    }

    @Override
    protected Diagnosis createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        String diagnosisCode = columnMap.get("diagnosis_code");
        String description = columnMap.get("description");
        return new Diagnosis(id, diagnosisCode, description);
    }
}
