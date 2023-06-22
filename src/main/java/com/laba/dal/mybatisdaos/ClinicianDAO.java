package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.models.Clinician;
import java.util.List;

public class ClinicianDAO extends EntityDAO<Clinician> implements IClinicianDAO {

    @Override
    public List<Clinician> getCliniciansByDepartmentId(int departmentId) {
        return session.getMapper(IClinicianDAO.class).getCliniciansByDepartmentId(departmentId);
    }

}
