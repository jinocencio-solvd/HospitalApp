package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.enums.FileType;
import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.interfaces.services.IMedicalRecordService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.MedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;
import java.util.List;

public class MedicalRecordService implements IEntityService<MedicalRecord>, IMedicalRecordService, IMedicalRecordDAO {

    private static IMedicalRecordDAO dao;
    public static com.laba.dal.jdbcdaos.MedicalRecordDAO medicalRecordDAO;
    public static final String MEDICAL_RECORDS_DIR = "/patient_records/";
    public static final String FILENAME_PREFIX = "medical_record_patientId_";

    public MedicalRecordService(DaoType daoType) {
        String model = "medical record";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.MedicalRecordDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (MedicalRecordDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<MedicalRecord> getAll() {
        return dao.getAll();
    }

    @Override
    public MedicalRecord getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(MedicalRecord entity) {
        dao.save(entity);
    }

    @Override
    public void update(MedicalRecord entity) {
        dao.update(entity);
    }

    public void getXmlPatientMedicalRecords(Patient p) {
        List<MedicalRecord> patientMedicalRecords = getMedicalRecordsForPatient(p);
        p.setMedicalRecords(patientMedicalRecords);
        String filepath =
            MEDICAL_RECORDS_DIR + FILENAME_PREFIX + p.getId() + FileType.XML.getExtension();
        JAXBUtil.marshallOneXmlOut(p, filepath);
    }

    public void getJsonPatientMedicalRecordsFromXml(Patient p, String filepath) {
        Patient patient = (Patient) JAXBUtil.unmarshallOne(p.getClass(), filepath);
        String filepathJson =
            MEDICAL_RECORDS_DIR + FILENAME_PREFIX + p.getId() + FileType.JSON.getExtension();
        JacksonUtil.toJsonFile(patient, filepathJson);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        return medicalRecordDAO.getMedicalRecordsForPatient(p);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        return dao.getMedicalRecordsByAppointmentId(appointmentId);
    }
}
