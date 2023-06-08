package com.laba.jdbc;

public class DAOFactory {
    public static <T extends EntityDAO<?>> T getJDBCDAO(String type){

        switch(type){
            case "appointment":
                return (T) new AppointmentDAO();
            case "clinician":
                return (T) new ClinicianDAO();
            case "department":
                return (T) new DepartmentDAO();
            case "diagnosis":
                return (T) new DiagnosisDAO();
            case "medical record":
                return (T) new MedicalRecordDAO();
            case "medication type":
                return (T) new MedicationDAO();
            case "medication":
                return (T) new MedicationTypeDAO();
            case "patient":
                return (T) new PatientDAO();
            case "person":
                return (T) new PersonDAO();
            case "prescription":
                return (T) new PrescriptionDAO();
            case "profession":
                return (T) new ProfessionDAO();
            case "room":
                return (T) new RoomDAO();
            case "specialization":
                return (T) new SpecializationDAO();
            case "staff":
                return (T) new StaffDAO();
            case "treatment":
                return (T) new TreatmentDAO();
        }
        return null;
    }
}
