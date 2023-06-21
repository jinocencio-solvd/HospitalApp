package com.laba.dal.mybatisDAOs;

import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.models.MedicalRecord;
import java.util.List;

public class MedicalRecordMbDAO extends EntityMbDAO<MedicalRecord> implements IMedicalRecordDAO {

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        return session.selectList(getNamespace() + ".getMedicalRecordsByAppointmentId",
            appointmentId);
    }
}
