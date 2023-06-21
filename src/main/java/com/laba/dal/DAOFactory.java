package com.laba.dal;

public class DAOFactory {

    public static com.laba.dal.jdbcdaos.EntityDAO<?> getJDBCDAO(String type) {
        switch (type) {
            case "appointment":
                return new com.laba.dal.jdbcdaos.AppointmentDAO();
            case "clinician":
                return new com.laba.dal.jdbcdaos.ClinicianDAO();
            case "department":
                return new com.laba.dal.jdbcdaos.DepartmentDAO();
            case "diagnosis":
                return new com.laba.dal.jdbcdaos.DiagnosisDAO();
            case "medical record":
                return new com.laba.dal.jdbcdaos.MedicalRecordDAO();
            case "medication type":
                return new com.laba.dal.jdbcdaos.MedicationDAO();
            case "medication":
                return new com.laba.dal.jdbcdaos.MedicationTypeDAO();
            case "patient":
                return new com.laba.dal.jdbcdaos.PatientDAO();
            case "person":
                return new com.laba.dal.jdbcdaos.PersonDAO();
            case "prescription":
                return new com.laba.dal.jdbcdaos.PrescriptionDAO();
            case "profession":
                return new com.laba.dal.jdbcdaos.ProfessionDAO();
            case "room":
                return new com.laba.dal.jdbcdaos.RoomDAO();
            case "specialization":
                return new com.laba.dal.jdbcdaos.SpecializationDAO();
            case "staff":
                return new com.laba.dal.jdbcdaos.StaffDAO();
            case "treatment":
                return new com.laba.dal.jdbcdaos.TreatmentDAO();
            default:
                throw new IllegalArgumentException("Invalid model input");
        }
    }

    public static com.laba.dal.mybatisdaos.EntityDAO<?> getMyBatisDAO(String type) {
        switch (type) {
            case "appointment":
                return new com.laba.dal.mybatisdaos.AppointmentDAO();
            case "clinician":
                return new com.laba.dal.mybatisdaos.ClinicianDAO();
            case "department":
                return new com.laba.dal.mybatisdaos.DepartmentDAO();
            case "diagnosis":
                return new com.laba.dal.mybatisdaos.DiagnosisDAO();
            case "medical record":
                return new com.laba.dal.mybatisdaos.MedicalRecordDAO();
            case "medication type":
                return new com.laba.dal.mybatisdaos.MedicationDAO();
            case "medication":
                return new com.laba.dal.mybatisdaos.MedicationTypeDAO();
            case "patient":
                return new com.laba.dal.mybatisdaos.PatientDAO();
            case "person":
                return new com.laba.dal.mybatisdaos.PersonDAO();
            case "prescription":
                return new com.laba.dal.mybatisdaos.PrescriptionDAO();
            case "profession":
                return new com.laba.dal.mybatisdaos.ProfessionDAO();
            case "room":
                return new com.laba.dal.mybatisdaos.RoomDAO();
            case "specialization":
                return new com.laba.dal.mybatisdaos.SpecializationDAO();
            case "staff":
                return new com.laba.dal.mybatisdaos.StaffDAO();
            case "treatment":
                return new com.laba.dal.mybatisdaos.TreatmentDAO();
            default:
                throw new IllegalArgumentException("Invalid model input");
        }
    }
}
