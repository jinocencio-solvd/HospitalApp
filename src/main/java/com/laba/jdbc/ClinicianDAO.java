package com.laba.jdbc;

import com.laba.model.Clinician;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClinicianDAO extends EntityDAO<Clinician> {

    @Override
    protected String getTableName() {
        return "clinicians";
    }

    @Override
    protected Clinician createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        int staffId = Integer.parseInt(columnMap.get("staff_id"));
        int professionId = Integer.parseInt(columnMap.get("profession_id"));
        int specializationId = Integer.parseInt(columnMap.get("specialization_id"));
        return new Clinician(id, staffId, professionId, specializationId);
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Clinician entity) {
        Map<String, Object> getters = new LinkedHashMap<>();
        getters.put("id", entity.getId());
        getters.put("staff_id", entity.getStaffId());
        getters.put("profession_id", entity.getProfessionId());
        getters.put("specialization_id;", entity.getSpecializationId());
        return getters;
    }
}