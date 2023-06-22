package com.laba.dal.daofactories;

import com.laba.dal.mybatisdaos.AppointmentDAO;
import com.laba.dal.mybatisdaos.ClinicianDAO;
import com.laba.dal.mybatisdaos.DepartmentDAO;
import com.laba.dal.mybatisdaos.DiagnosisDAO;
import com.laba.dal.mybatisdaos.EntityDAO;
import com.laba.dal.mybatisdaos.MedicalRecordDAO;
import com.laba.dal.mybatisdaos.MedicationDAO;
import com.laba.dal.mybatisdaos.MedicationTypeDAO;
import com.laba.dal.mybatisdaos.PatientDAO;
import com.laba.dal.mybatisdaos.PersonDAO;
import com.laba.dal.mybatisdaos.PrescriptionDAO;
import com.laba.dal.mybatisdaos.ProfessionDAO;
import com.laba.dal.mybatisdaos.RoomDAO;
import com.laba.dal.mybatisdaos.SpecializationDAO;
import com.laba.dal.mybatisdaos.StaffDAO;
import com.laba.dal.mybatisdaos.TreatmentDAO;

public class MyBatisDAOFactory extends AbstractDAOFactory {

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
