package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IMedicationTypeDAO;
import com.laba.models.MedicationType;

public class MedicationTypeService extends
    EntityService<MedicationType, IMedicationTypeDAO> implements
    IMedicationTypeDAO {

    public MedicationTypeService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "medication type";
    }

}
