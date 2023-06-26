package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IMedicationDAO;
import com.laba.models.Medication;
import java.util.List;

public class MedicationDAO extends EntityDAO<Medication> implements IMedicationDAO {

    @Override
    public List<Medication> getMedicationsByPatientId(int patientId) {
        return session.getMapper(IMedicationDAO.class).getMedicationsByPatientId(patientId);
    }

}
