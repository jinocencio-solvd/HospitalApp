package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.models.Clinician;

public class ClinicianDAO extends EntityDAO<Clinician> implements IClinicianDAO {

    @Override
    protected String getTableName() {
        return "clinicians";
    }
}
