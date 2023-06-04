package com.laba.jdbc;

import com.laba.model.Medication;
import java.util.LinkedHashMap;
import java.util.Map;

public class MedicationDAO extends EntityDAO<Medication> {

    @Override
    protected String getTableName() {
        return "medication";
    }

    @Override
    protected Medication createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        String medicationName = columnMap.get("medication_name");
        int medicationTypeId = Integer.parseInt(columnMap.get("medication_type_id"));
        return new Medication(id, medicationName, medicationTypeId);
    }
}
