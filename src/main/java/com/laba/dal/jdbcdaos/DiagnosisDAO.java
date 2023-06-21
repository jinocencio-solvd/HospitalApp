package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.models.Diagnosis;

public class DiagnosisDAO extends EntityDAO<Diagnosis> implements IDiagnosisDAO {

    @Override
    protected String getTableName() {
        return "diagnosis";
    }

}
