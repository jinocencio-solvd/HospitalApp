package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.models.Diagnosis;

public class DiagnosisService extends EntityService<Diagnosis, IDiagnosisDAO> implements
    IDiagnosisDAO {

    public DiagnosisService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "diagnosis";
    }

}
