package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.models.Treatment;
import java.util.List;

public class TreatmentService extends EntityService<Treatment, ITreatmentDAO> implements
    ITreatmentDAO {

    public TreatmentService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "treatment";
    }

    @Override
    public List<Treatment> getTreatmentsByPatientId(int patientId) {
        return dao.getTreatmentsByPatientId(patientId);
    }

}
