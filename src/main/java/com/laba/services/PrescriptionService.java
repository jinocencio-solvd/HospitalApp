package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPrescriptionDAO;
import com.laba.models.Prescription;
import java.util.List;

public class PrescriptionService extends EntityService<Prescription, IPrescriptionDAO> implements
    IPrescriptionDAO {

    public PrescriptionService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "prescription";
    }

    @Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        return dao.getPrescriptionsByPatientId(patientId);
    }

}
