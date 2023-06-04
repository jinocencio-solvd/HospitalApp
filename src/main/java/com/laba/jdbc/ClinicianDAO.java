package com.laba.jdbc;

import com.laba.model.Clinician;

public class ClinicianDAO extends EntityDAO<Clinician> {

    @Override
    protected String getTableName() {
        return "clinicians";
    }
}
