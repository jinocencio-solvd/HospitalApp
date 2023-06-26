package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.models.Specialization;

public class SpecializationDAO extends EntityDAO<Specialization> implements ISpecializationDAO {

    @Override
    protected String getTableName() {
        return "specializations";
    }

    @Override
    public Specialization getSpecializationByClinicianId(int clinicianId) {
        String query = "SELECT *\n"
            + "FROM specializations\n"
            + "JOIN clinicians c on specializations.id = c.specialization_id\n"
            + "WHERE c.id = " + clinicianId;
        return retrieveEntity(query, new Specialization());
    }

}
