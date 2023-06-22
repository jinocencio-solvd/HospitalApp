package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.models.Specialization;

public class SpecializationDAO extends EntityDAO<Specialization> implements ISpecializationDAO {

    @Override
    public Specialization getSpecializationByClinicianId(int clinicianId) {
        return session.getMapper(ISpecializationDAO.class)
            .getSpecializationByClinicianId(clinicianId);
    }

}
