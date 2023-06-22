package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.models.Treatment;
import java.util.List;

public class TreatmentDAO extends EntityDAO<Treatment> implements ITreatmentDAO {

    @Override
    public List<Treatment> getTreatmentsByPatientId(int patientId) {
        return session.getMapper(ITreatmentDAO.class).getTreatmentsByPatientId(patientId);
    }

}
