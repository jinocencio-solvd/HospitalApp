package com.laba.dal;

import com.laba.dal.mybatisDAOs.AppointmentMbDAO;
import com.laba.dal.mybatisDAOs.ClinicianMbDAO;
import com.laba.dal.mybatisDAOs.DepartmentMbDAO;
import com.laba.dal.mybatisDAOs.DiagnosisMbDAO;
import com.laba.dal.mybatisDAOs.EntityMbDAO;
import com.laba.dal.mybatisDAOs.MedicalRecordMbDAO;
import com.laba.dal.mybatisDAOs.MedicationMbDAO;
import com.laba.dal.mybatisDAOs.MedicationTypeMbDAO;
import com.laba.dal.mybatisDAOs.PatientMbDAO;
import com.laba.dal.mybatisDAOs.PersonMbDAO;
import com.laba.dal.mybatisDAOs.PrescriptionMbDAO;
import com.laba.dal.mybatisDAOs.ProfessionMbDAO;
import com.laba.dal.mybatisDAOs.RoomMbDAO;
import com.laba.dal.mybatisDAOs.SpecializationMbDAO;
import com.laba.dal.mybatisDAOs.StaffMbDAO;
import com.laba.dal.mybatisDAOs.TreatmentMbDAO;
import com.laba.dal.jdbc.AppointmentDAO;
import com.laba.dal.jdbc.ClinicianDAO;
import com.laba.dal.jdbc.DepartmentDAO;
import com.laba.dal.jdbc.DiagnosisDAO;
import com.laba.dal.jdbc.EntityDAO;
import com.laba.dal.jdbc.MedicalRecordDAO;
import com.laba.dal.jdbc.MedicationDAO;
import com.laba.dal.jdbc.MedicationTypeDAO;
import com.laba.dal.jdbc.PatientDAO;
import com.laba.dal.jdbc.PersonDAO;
import com.laba.dal.jdbc.PrescriptionDAO;
import com.laba.dal.jdbc.ProfessionDAO;
import com.laba.dal.jdbc.RoomDAO;
import com.laba.dal.jdbc.SpecializationDAO;
import com.laba.dal.jdbc.StaffDAO;
import com.laba.dal.jdbc.TreatmentDAO;

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
