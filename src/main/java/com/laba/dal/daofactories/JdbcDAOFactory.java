package com.laba.dal.daofactories;

import com.laba.dal.jdbcdaos.AppointmentDAO;
import com.laba.dal.jdbcdaos.ClinicianDAO;
import com.laba.dal.jdbcdaos.DepartmentDAO;
import com.laba.dal.jdbcdaos.DiagnosisDAO;
import com.laba.dal.jdbcdaos.EntityDAO;
import com.laba.dal.jdbcdaos.MedicalRecordDAO;
import com.laba.dal.jdbcdaos.MedicationDAO;
import com.laba.dal.jdbcdaos.MedicationTypeDAO;
import com.laba.dal.jdbcdaos.PatientDAO;
import com.laba.dal.jdbcdaos.PersonDAO;
import com.laba.dal.jdbcdaos.PrescriptionDAO;
import com.laba.dal.jdbcdaos.ProfessionDAO;
import com.laba.dal.jdbcdaos.RoomDAO;
import com.laba.dal.jdbcdaos.SpecializationDAO;
import com.laba.dal.jdbcdaos.StaffDAO;
import com.laba.dal.jdbcdaos.TreatmentDAO;

public class JdbcDAOFactory extends AbstractDAOFactory {

    @Override
    public EntityDAO<?> getDAO(String type) {
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
                return new MedicationTypeDAO();
            case "medication":
                return new MedicationDAO();
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

}
