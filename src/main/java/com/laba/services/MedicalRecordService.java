package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.enums.FileType;
import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.models.DecoratedPatient;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;
import java.util.List;

public class MedicalRecordService extends EntityService<MedicalRecord, IMedicalRecordDAO> implements
    IMedicalRecordDAO {

    public static final String MEDICAL_RECORDS_DIR = "/patient_records/";
    public static final String FILENAME_PREFIX = "medical_record_patientId_";

    public MedicalRecordService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "medical record";
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        return dao.getMedicalRecordsByAppointmentId(appointmentId);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        return dao.getMedicalRecordsForPatient(p);
    }

    public void getXmlPatientMedicalRecords(Patient p) {
        List<MedicalRecord> patientMedicalRecords = getMedicalRecordsForPatient(p);
        DecoratedPatient decoratedPatient = new DecoratedPatient(p);
        decoratedPatient.setMedicalRecords(patientMedicalRecords);
        String filepath =
            MEDICAL_RECORDS_DIR + FILENAME_PREFIX + p.getId() + FileType.XML.getExtension();
        JAXBUtil.marshallOneXmlOut(decoratedPatient, filepath);
    }

    public void getJsonPatientMedicalRecordsFromXml(Patient p, String filepath) {
        Patient patient = (Patient) JAXBUtil.unmarshallOne(p.getClass(), filepath);
        String filepathJson =
            MEDICAL_RECORDS_DIR + FILENAME_PREFIX + p.getId() + FileType.JSON.getExtension();
        JacksonUtil.toJsonFile(patient, filepathJson);
    }

}
