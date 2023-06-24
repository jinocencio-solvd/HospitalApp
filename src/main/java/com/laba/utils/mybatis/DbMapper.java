package com.laba.utils.mybatis;

import java.util.LinkedHashMap;
import java.util.Map;

public class DbMapper {

    public static final String interfaceLoc = "com.laba.interfaces.daos.";
    public static final String modelLoc = "com.laba.models.";

    public static Map<String, Map<String, String>> getPropertyColumnMap() {
        Map<String, Map<String, String>> propColMap = new LinkedHashMap<>();
        propColMap.put("person", populatePersonMap());
//        propColMap.put("appointment", populateAppointmentMap());
//        propColMap.put("clinician", populateClinicianMap());
//        propColMap.put("department", populateDepartmentMap());
//        propColMap.put("diagnosis", populateDiagnosisMap());
//        propColMap.put("medical_record", populateMedicalRecordMap());
//        propColMap.put("medication", populateMedicationMap());
//        propColMap.put("medication_type", populateMedicationTypeMap());
        propColMap.put("patient", populatePatientMap());
//        propColMap.put("prescription", populatePrescriptionMap());
//        propColMap.put("profession", populateProfessionMap());
//        propColMap.put("room", populateRoomMap());
//        propColMap.put("specialization", populateSpecializationMap());
//        propColMap.put("staff", populateStaffMap());
//        propColMap.put("treatment", populateTreatmentMap());
        return propColMap;
    }

//    private static Map<String, String> populateTreatmentMap() {
//        Map<String, String> treatmentPropColMap = new LinkedHashMap<>();
//        treatmentPropColMap.put("type", modelLoc + "Treatment");
//        treatmentPropColMap.put("namespace", interfaceLoc + "ITreatmentDAO");
//        treatmentPropColMap.put("table_name", "treatments");
//        treatmentPropColMap.put("field_id", "id");
//        treatmentPropColMap.put("field_treatmentName", "treatment_name");
//        return treatmentPropColMap;
//    }
//
//    private static Map<String, String> populateStaffMap() {
//        Map<String, String> staffPropColMap = new LinkedHashMap<>();
//        staffPropColMap.put("type", modelLoc + "Staff");
//        staffPropColMap.put("namespace", interfaceLoc + "IStaffDAO");
//        staffPropColMap.put("table_name", "staff");
//        staffPropColMap.put("field_id", "id");
//        staffPropColMap.put("field_personId", "person_id");
//        return staffPropColMap;
//    }
//
//    private static Map<String, String> populateSpecializationMap() {
//        Map<String, String> specializationPropColMap = new LinkedHashMap<>();
//        specializationPropColMap.put("type", modelLoc + "Specialization");
//        specializationPropColMap.put("namespace", interfaceLoc + "ISpecializationDAO");
//        specializationPropColMap.put("table_name", "specializations");
//        specializationPropColMap.put("field_id", "id");
//        specializationPropColMap.put("field_specialization", "specialization");
//        return specializationPropColMap;
//    }
//
//    private static Map<String, String> populateRoomMap() {
//        Map<String, String> roomPropColMap = new LinkedHashMap<>();
//        roomPropColMap.put("type", modelLoc + "Room");
//        roomPropColMap.put("namespace", interfaceLoc + "IRoomDAO");
//        roomPropColMap.put("table_name", "rooms");
//        roomPropColMap.put("field_id", "id");
//        roomPropColMap.put("field_roomNumber", "room_number");
//        roomPropColMap.put("field_departmentId", "department_id");
//        return roomPropColMap;
//    }
//
//
//    private static Map<String, String> populateProfessionMap() {
//        Map<String, String> professionPropColMap = new LinkedHashMap<>();
//        professionPropColMap.put("type", modelLoc + "Profession");
//        professionPropColMap.put("namespace", interfaceLoc + "IProfessionDAO");
//        professionPropColMap.put("table_name", "professions");
//        professionPropColMap.put("field_id", "id");
//        professionPropColMap.put("field_profession", "profession");
//        return professionPropColMap;
//    }
//
//    private static Map<String, String> populatePrescriptionMap() {
//        Map<String, String> prescriptionPropColMap = new LinkedHashMap<>();
//        prescriptionPropColMap.put("type", modelLoc + "Prescription");
//        prescriptionPropColMap.put("namespace", interfaceLoc + "IPrescriptionDAO");
//        prescriptionPropColMap.put("table_name", "prescriptions");
//        prescriptionPropColMap.put("field_id", "id");
//        prescriptionPropColMap.put("field_treatmentId", "treatment_id");
//        prescriptionPropColMap.put("field_medicationId", "medication_id");
//        prescriptionPropColMap.put("field_dosage", "dosage");
//        prescriptionPropColMap.put("field_prescriptionStartDate", "prescription_start_date");
//        prescriptionPropColMap.put("field_prescriptionExpirationDate",
//            "prescription_expiration_date");
//        return prescriptionPropColMap;
//    }
//
    private static Map<String, String> populatePersonMap() {
        Map<String, String> personPropColMap = new LinkedHashMap<>();
        personPropColMap.put("type", modelLoc + "Person");
        personPropColMap.put("namespace", interfaceLoc + "IPersonDAO");
        personPropColMap.put("table_name", "persons");
        personPropColMap.put("field_id", "id");
        personPropColMap.put("field_firstName", "first_name");
        personPropColMap.put("field_lastName", "last_name");
        personPropColMap.put("field_dob", "dob");
        return personPropColMap;
    }

    private static Map<String, String> populatePatientMap() {
        Map<String, String> patientPropColMap = new LinkedHashMap<>();
        patientPropColMap.put("type", modelLoc + "Patient");
        patientPropColMap.put("namespace", interfaceLoc + "IPatientDAO");
        patientPropColMap.put("table_name", "patients");
        patientPropColMap.put("field_id", "id");
        return patientPropColMap;
    }
//
//    private static Map<String, String> populateMedicationTypeMap() {
//        Map<String, String> medicationTypePropColMap = new LinkedHashMap<>();
//        medicationTypePropColMap.put("type", modelLoc + "MedicationType");
//        medicationTypePropColMap.put("namespace", interfaceLoc + "IMedicationTypeDAO");
//        medicationTypePropColMap.put("table_name", "medication_types");
//        medicationTypePropColMap.put("field_id", "id");
//        medicationTypePropColMap.put("field_medicationType", "medication_type");
//        return medicationTypePropColMap;
//    }
//
//
//    private static Map<String, String> populateMedicationMap() {
//        Map<String, String> medicationPropColMap = new LinkedHashMap<>();
//        medicationPropColMap.put("type", modelLoc + "Medication");
//        medicationPropColMap.put("namespace", interfaceLoc + "IMedicationDAO");
//        medicationPropColMap.put("table_name", "medications");
//        medicationPropColMap.put("field_id", "id");
//        medicationPropColMap.put("field_medicationName", "medication_name");
//        medicationPropColMap.put("field_medicationTypesId", "medication_types_id");
//        return medicationPropColMap;
//    }
//
//    private static Map<String, String> populateMedicalRecordMap() {
//        Map<String, String> medicalRecordPropColMap = new LinkedHashMap<>();
//        medicalRecordPropColMap.put("type", modelLoc + "MedicalRecord");
//        medicalRecordPropColMap.put("namespace", interfaceLoc + "IMedicalRecordDAO");
//        medicalRecordPropColMap.put("table_name", "medical_records");
//        medicalRecordPropColMap.put("field_id", "id");
//        medicalRecordPropColMap.put("field_appointmentId", "appointment_id");
//        medicalRecordPropColMap.put("field_diagnosisId", "diagnosis_id");
//        medicalRecordPropColMap.put("field_treatmentId", "treatment_id");
//        return medicalRecordPropColMap;
//    }
//
//    private static Map<String, String> populateDiagnosisMap() {
//        Map<String, String> diagnosisPropColMap = new LinkedHashMap<>();
//        diagnosisPropColMap.put("type", modelLoc + "Diagnosis");
//        diagnosisPropColMap.put("namespace", interfaceLoc + "IDiagnosisDAO");
//        diagnosisPropColMap.put("table_name", "diagnoses");
//        diagnosisPropColMap.put("field_id", "id");
//        diagnosisPropColMap.put("field_diagnosisCode", "diagnosis_code");
//        diagnosisPropColMap.put("field_description", "description");
//        return diagnosisPropColMap;
//    }
//
//    private static Map<String, String> populateDepartmentMap() {
//        Map<String, String> departmentPropColMap = new LinkedHashMap<>();
//        departmentPropColMap.put("type", modelLoc + "Department");
//        departmentPropColMap.put("namespace", interfaceLoc + "IDepartmentDAO");
//        departmentPropColMap.put("table_name", "departments");
//        departmentPropColMap.put("field_id", "id");
//        departmentPropColMap.put("field_departmentName", "department_name");
//        return departmentPropColMap;
//    }
//
//    private static Map<String, String> populateClinicianMap() {
//        Map<String, String> clinicianPropColMap = new LinkedHashMap<>();
//        clinicianPropColMap.put("type", modelLoc + "Clinician");
//        clinicianPropColMap.put("namespace", interfaceLoc + "IClinicianDAO");
//        clinicianPropColMap.put("table_name", "clinicians");
//        clinicianPropColMap.put("field_id", "id");
//        clinicianPropColMap.put("field_staffId", "staff_id");
//        clinicianPropColMap.put("field_professionId", "profession_id");
//        clinicianPropColMap.put("field_specializationId", "specialization_id");
//        return clinicianPropColMap;
//    }

//    private static Map<String, String> populateAppointmentMap() {
//        Map<String, String> appointmentPropColMap = new LinkedHashMap<>();
//        appointmentPropColMap.put("type", modelLoc + "Appointment");
//        appointmentPropColMap.put("namespace", interfaceLoc + "IAppointmentDAO");
//        appointmentPropColMap.put("table_name", "appointments");
//        appointmentPropColMap.put("field_id", "id");
//        appointmentPropColMap.put("field_patient", "patient.patient_id");
//        appointmentPropColMap.put("field_clinician", "clinician.clinician_id");
//        appointmentPropColMap.put("field_room", "room.room_id");
//        appointmentPropColMap.put("field_appointmentDate", "appointment_date");
//        appointmentPropColMap.put("field_appointmentTime", "appointment_time");
//        return appointmentPropColMap;
//    }

}
