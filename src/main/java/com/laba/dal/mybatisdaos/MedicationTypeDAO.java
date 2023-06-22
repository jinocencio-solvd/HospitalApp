package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IMedicationTypeDAO;
import com.laba.models.MedicationType;
import java.util.List;

public class MedicationTypeDAO extends EntityDAO<MedicationType> implements IMedicationTypeDAO {

    @Override
    public List<MedicationType> getMedicationTypesByClinicianId(int clinicianId) {
        return session.getMapper(IMedicationTypeDAO.class)
            .getMedicationTypesByClinicianId(clinicianId);
    }

}
