package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.models.Diagnosis;
import java.util.List;

public class DiagnosisDAO extends EntityDAO<Diagnosis> implements IDiagnosisDAO {

    @Override
    public List<Diagnosis> getDiagnosisByDepartmentId(int departmentId) {
        return session.getMapper(IDiagnosisDAO.class).getDiagnosisByDepartmentId(departmentId);
    }

}
