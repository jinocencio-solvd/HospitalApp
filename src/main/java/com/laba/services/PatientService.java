package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;

public class PatientService extends EntityService<Patient, IPatientDAO> implements IPatientDAO {

    public PatientService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "patient";
    }

    @Override
    public Patient getPatientByPersonId(int personId) {
        return dao.getPatientByPersonId(personId);
    }

}
