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

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Diagnosis entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id",entity.getId() );
        getters.put("diagnosis_code",entity.getDiagnosis_code() );
        getters.put("description",entity.getDescription() );
        return getters;
    }
}
