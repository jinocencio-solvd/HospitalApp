package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.models.Clinician;

public class ClinicianService extends EntityService<Clinician, IClinicianDAO> implements
    IClinicianDAO {

    public ClinicianService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "clinician";
    }

}
