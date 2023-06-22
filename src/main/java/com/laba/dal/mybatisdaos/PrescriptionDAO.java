package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IPrescriptionDAO;
import com.laba.models.Prescription;
import java.util.List;

public class PrescriptionDAO extends EntityDAO<Prescription> implements IPrescriptionDAO {

    @Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        return session.getMapper(IPrescriptionDAO.class).getPrescriptionsByPatientId(patientId);
    }

}
