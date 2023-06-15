package com.laba.services;

import com.laba.enums.FileType;
import com.laba.interfaces.IMedicalRecordService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.MedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;
import java.io.File;
import java.util.List;

public class MedicalRecordService implements IMedicalRecordService {

    public static MedicalRecordDAO medicalRecordDAO;
    public static final String MEDICAL_RECORDS_DIR = "/patient_records/";
    public static final String FILENAME_PREFIX = "medical_record_patientId_";

    public MedicalRecordService() {
        medicalRecordDAO = DAOFactory.getJDBCDAO("medical record");
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

    public void getXmlPatientMedicalRecords(Patient p) {
        List<MedicalRecord> patientMedicalRecords = getMedicalRecordsForPatient(p);
        p.setMedicalRecords(patientMedicalRecords);
        String filename = FILENAME_PREFIX + p.getId()+ FileType.XML.getExtension();
        JAXBUtil.marshallOneXmlOut(p, filename);
    }

    public void getJsonPatientMedicalRecordsFromXml(Patient p, File xmlFile) {
        Patient patient = (Patient) JAXBUtil.unmarshallOne(p.getClass(), xmlFile);
        String filepath = FILENAME_PREFIX + p.getId() + FileType.JSON.getExtension();
        JacksonUtil.toJsonFile(patient, filepath);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        return medicalRecordDAO.getMedicalRecordsForPatient(p);
    }
}
