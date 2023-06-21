package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IMedicationDAO;
import com.laba.models.Medication;

public class MedicationService extends EntityService<Medication, IMedicationDAO> implements
    IMedicationDAO {

    public MedicationService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "medication";
    }

}
