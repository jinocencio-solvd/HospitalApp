package com.laba.jdbc;

import com.laba.jdbc.mybatisDAOs.AppointmentMbDAO;
import com.laba.jdbc.mybatisDAOs.ClinicianMbDAO;
import com.laba.jdbc.mybatisDAOs.DepartmentMbDAO;
import com.laba.jdbc.mybatisDAOs.DiagnosisMbDAO;
import com.laba.jdbc.mybatisDAOs.EntityMbDAO;
import com.laba.jdbc.mybatisDAOs.MedicalRecordMbDAO;
import com.laba.jdbc.mybatisDAOs.MedicationMbDAO;
import com.laba.jdbc.mybatisDAOs.MedicationTypeMbDAO;
import com.laba.jdbc.mybatisDAOs.PatientMbDAO;
import com.laba.jdbc.mybatisDAOs.PersonMbDAO;
import com.laba.jdbc.mybatisDAOs.PrescriptionMbDAO;
import com.laba.jdbc.mybatisDAOs.ProfessionMbDAO;
import com.laba.jdbc.mybatisDAOs.RoomMbDAO;
import com.laba.jdbc.mybatisDAOs.SpecializationMbDAO;
import com.laba.jdbc.mybatisDAOs.StaffMbDAO;
import com.laba.jdbc.mybatisDAOs.TreatmentMbDAO;

public class DAOFactory {

    public static EntityDAO<?> getJDBCDAO(String type) {
        switch (type) {
            case "appointment":
                return new AppointmentDAO();
            case "clinician":
                return new ClinicianDAO();
            case "department":
                return new DepartmentDAO();
            case "diagnosis":
                return new DiagnosisDAO();
            case "medical record":
                return new MedicalRecordDAO();
            case "medication type":
                return new MedicationDAO();
            case "medication":
                return new MedicationTypeDAO();
            case "patient":
                return new PatientDAO();
            case "person":
                return new PersonDAO();
            case "prescription":
                return new PrescriptionDAO();
            case "profession":
                return new ProfessionDAO();
            case "room":
                return new RoomDAO();
            case "specialization":
                return new SpecializationDAO();
            case "staff":
                return new StaffDAO();
            case "treatment":
                return new TreatmentDAO();
            default:
                throw new IllegalArgumentException("Invalid model input");
        }
    }

    public static EntityMbDAO<?> getMyBatisDAO(String type) {
        switch (type) {
            case "appointment":
                return new AppointmentMbDAO();
            case "clinician":
                return new ClinicianMbDAO();
            case "department":
                return new DepartmentMbDAO();
            case "diagnosis":
                return new DiagnosisMbDAO();
            case "medical record":
                return new MedicalRecordMbDAO();
            case "medication type":
                return new MedicationMbDAO();
            case "medication":
                return new MedicationTypeMbDAO();
            case "patient":
                return new PatientMbDAO();
            case "person":
                return new PersonMbDAO();
            case "prescription":
                return new PrescriptionMbDAO();
            case "profession":
                return new ProfessionMbDAO();
            case "room":
                return new RoomMbDAO();
            case "specialization":
                return new SpecializationMbDAO();
            case "staff":
                return new StaffMbDAO();
            case "treatment":
                return new TreatmentMbDAO();
            default:
                throw new IllegalArgumentException("Invalid model input");
        }
    }
}
