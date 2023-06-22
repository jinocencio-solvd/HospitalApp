package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.models.Diagnosis;
import java.util.List;

public class DiagnosisService extends EntityService<Diagnosis, IDiagnosisDAO> implements
    IDiagnosisDAO {

    public DiagnosisService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "diagnosis";
    }

    @Override
    public List<Diagnosis> getDiagnosisByDepartmentId(int departmentId) {
        return dao.getDiagnosisByDepartmentId(departmentId);
    }

}
