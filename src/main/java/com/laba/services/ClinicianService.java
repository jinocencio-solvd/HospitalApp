package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.models.Clinician;
import java.util.List;

public class ClinicianService extends EntityService<Clinician, IClinicianDAO> implements
    IClinicianDAO {

    public ClinicianService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "clinician";
    }

    @Override
    public List<Clinician> getCliniciansByDepartmentId(int departmentId) {
        return dao.getCliniciansByDepartmentId(departmentId);
    }

}
