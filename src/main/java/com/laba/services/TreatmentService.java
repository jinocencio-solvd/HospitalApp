package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.models.Treatment;

public class TreatmentService extends EntityService<Treatment, ITreatmentDAO> implements
    ITreatmentDAO {

    public TreatmentService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "treatment";
    }

}
