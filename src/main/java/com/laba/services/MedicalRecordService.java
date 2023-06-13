package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.MedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;

public class MedicalRecordService implements IEntityService<MedicalRecord> {

    private static MedicalRecordService instance;
    private final MedicalRecordDAO medicalRecordDAO;

    private MedicalRecordService() {
        medicalRecordDAO = DAOFactory.getJDBCDAO("medical record");
    }

    public static MedicalRecordService getInstance() {
        if (instance == null) {
            instance = new MedicalRecordService();
        }
        return instance;
    }

    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        return medicalRecordDAO.getMedicalRecordsForPatient(p);
    }

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
