package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.models.Specialization;

public class SpecializationService extends
    EntityService<Specialization, ISpecializationDAO> implements
    ISpecializationDAO {

    public SpecializationService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "specialization";
    }

}
