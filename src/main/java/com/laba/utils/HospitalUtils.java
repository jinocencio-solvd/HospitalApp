package com.laba.utils;

import static com.laba.utils.AppConfig.xmlOutputDir;

import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.services.MedicalRecordService;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;
import java.io.File;
import java.util.List;

public class HospitalUtils {

    public static final String EXPORT_PATIENT_MEDICAL_RECORDS = "patient_records/";
    public static final String xmlFilenamePrefix = "patient_medical_record_patientId_";
    public static final String xmlFileType = ".xml";
    public static final String jsonFileType = ".json";

    public static void getXmlPatientMedicalRecords(Patient p) {
        List<MedicalRecord> patientMedicalRecords = MedicalRecordService.getInstance()
            .getMedicalRecordsForPatient(p);

        p.setMedicalRecords(patientMedicalRecords);
        JAXBUtil.marshallOneXmlOut(p, xmlOutputDir + EXPORT_PATIENT_MEDICAL_RECORDS,
            xmlFilenamePrefix + p.getId() + xmlFileType);
    }

    public static void getJsonPatientMedicalRecordsFromXml(Patient p, File xmlFile) {
        Patient patient = (Patient) JAXBUtil.unmarshallOne(p.getClass(), xmlFile);
        JacksonUtil.toJsonFile(patient, xmlFilenamePrefix + p.getId() + jsonFileType);
    }

}
