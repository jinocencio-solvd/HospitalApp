package com.laba.jdbc;

import com.laba.model.MedicationType;
import java.util.LinkedHashMap;
import java.util.Map;

public class MedicationTypeDAO extends EntityDAO<MedicationType> {

    @Override
    protected String getTableName() {
        return "medication_types";
    }

    @Override
    protected MedicationType createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        String medicationType = columnMap.get("medication_type");
        return new MedicationType(id, medicationType);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(MedicationType entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("medication_type", entity.getMedicationType());
        return getters;
    }
}
