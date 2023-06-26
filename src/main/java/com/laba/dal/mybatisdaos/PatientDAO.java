package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;

public class PatientDAO extends EntityDAO<Patient> implements IPatientDAO {

    @Override
    public Patient getPatientByPersonId(int personId) {
        return session.selectOne(getNamespace() + ".getPatientByPersonId", personId);
    }
}
