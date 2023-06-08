package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.MedicalRecordDAO;
import com.laba.models.MedicalRecord;
import java.util.List;

public class MedicalRecordService implements IEntityService<MedicalRecord> {

    private final MedicalRecordDAO medicalRecordDAO = DAOFactory.getJDBCDAO("medical records");

    @Override
    public List<MedicalRecord> getAll() {
        return medicalRecordDAO.getAll();
    }

    @Override
    public MedicalRecord getById(int id) {
        return medicalRecordDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        medicalRecordDAO.deleteById(id);
    }

    @Override
    public void save(MedicalRecord entity) {
        medicalRecordDAO.save(entity);
    }

    @Override
    public void update(MedicalRecord entity) {
        medicalRecordDAO.update(entity);
    }
}
