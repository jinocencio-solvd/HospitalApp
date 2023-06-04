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
}
