package com.laba.dal.jdbcdaos;

import com.laba.models.Appointment;
import com.laba.models.Clinician;
import com.laba.models.Department;
import com.laba.models.Diagnosis;
import com.laba.models.MedicalRecord;
import com.laba.models.Medication;
import com.laba.models.MedicationType;
import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.models.Prescription;
import com.laba.models.Profession;
import com.laba.models.Room;
import com.laba.models.Specialization;
import com.laba.models.Staff;
import com.laba.models.Treatment;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcModelAssociations {

    private static final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static final ClinicianDAO clinicianDAO = new ClinicianDAO();
    private static final DepartmentDAO departmentDAO = new DepartmentDAO();
    private static final DiagnosisDAO diagnosisDAO = new DiagnosisDAO();
    private static final MedicationDAO medicationDAO = new MedicationDAO();
    private static final MedicationTypeDAO medicationTypeDAO = new MedicationTypeDAO();
    private static final PatientDAO patientDAO = new PatientDAO();
    private static final PersonDAO personDAO = new PersonDAO();
    private static final ProfessionDAO professionDAO = new ProfessionDAO();
    private static final RoomDAO roomDAO = new RoomDAO();
    private static final SpecializationDAO specializationDAO = new SpecializationDAO();
    private static final TreatmentDAO treatmentDAO = new TreatmentDAO();

    protected static <T> T associateModel(T entity, ResultSet rs) throws SQLException {
        if (entity instanceof Appointment) {
            Appointment appointment = (Appointment) entity;
            appointment.setPatient(getPatient(rs));
            appointment.setClinician(getClinician(rs));
            appointment.setRoom(getRoom(rs));
        }
        if (entity instanceof Clinician) {
            Clinician clinician = (Clinician) entity;
            clinician.setProfession(getProfession(rs));
            clinician.setSpecialization(getSpecialization(rs));
        }
        if (entity instanceof MedicalRecord) {
            MedicalRecord medicalRecord = (MedicalRecord) entity;
            medicalRecord.setAppointment(getAppointment(rs));
            medicalRecord.setDiagnosis(getDiagnosis(rs));
            medicalRecord.setTreatment(getTreatment(rs));
        }
        if (entity instanceof Medication) {
            Medication medication = (Medication) entity;
            medication.setMedicationType(getMedicationType(rs));
        }
        if (entity instanceof Patient) {
            Patient patient = (Patient) entity;
            patient.setPerson(getPerson(rs));
        }
        if (entity instanceof Prescription) {
            Prescription prescription = (Prescription) entity;
            prescription.setTreatment(getTreatment(rs));
            prescription.setMedication((getMedication(rs)));
        }
        if (entity instanceof Room) {
            Room room = (Room) entity;
            room.setDepartment(getDepartment(rs));
        }
        if (entity instanceof Staff) {
            Staff staff = (Staff) entity;
            staff.setPerson(getPerson(rs));
        }
        return entity;
    }

    private static Person getPerson(ResultSet rs) throws SQLException {
        int personId = rs.getInt("person_id");
        return personDAO.getById(personId);
    }

    private static Clinician getClinician(ResultSet rs) throws SQLException {
        int clinicianId = rs.getInt("clinician_id");
        return clinicianDAO.getById(clinicianId);
    }

    private static Room getRoom(ResultSet rs) throws SQLException {
        int roomId = rs.getInt("room_id");
        return roomDAO.getById(roomId);
    }

    private static Patient getPatient(ResultSet rs) throws SQLException {
        int patientId = rs.getInt("patient_id");
        return patientDAO.getById(patientId);
    }

    private static Appointment getAppointment(ResultSet rs) throws SQLException {
        int appointmentId = rs.getInt("appointment_id");
        return appointmentDAO.getById(appointmentId);
    }

    private static Department getDepartment(ResultSet rs) throws SQLException {
        int departmentId = rs.getInt("department_id");
        return departmentDAO.getById(departmentId);
    }

    private static Diagnosis getDiagnosis(ResultSet rs) throws SQLException {
        int diagnosisId = rs.getInt("diagnosis_id");
        return diagnosisDAO.getById(diagnosisId);
    }

    private static Medication getMedication(ResultSet rs) throws SQLException {
        int medicationId = rs.getInt("medication_id");
        return medicationDAO.getById(medicationId);
    }

    private static MedicationType getMedicationType(ResultSet rs) throws SQLException {
        int medicationTypeId = rs.getInt("medication_types_id");
        return medicationTypeDAO.getById(medicationTypeId);
    }

    private static Profession getProfession(ResultSet rs) throws SQLException {
        int professionId = rs.getInt("profession_id");
        return professionDAO.getById(professionId);
    }

    private static Specialization getSpecialization(ResultSet rs) throws SQLException {
        int specializationId = rs.getInt("specialization_id");
        return specializationDAO.getById(specializationId);
    }

    private static Treatment getTreatment(ResultSet rs) throws SQLException {
        int treatmentId = rs.getInt("treatment_id");
        return treatmentDAO.getById(treatmentId);
    }

}
