package com.laba.models;

import java.util.Objects;

public class MedicalRecord {
    private int id;
    private int appointmentId;
    private int diagnosisId;
    private int treatmentId;

    public MedicalRecord(int appointmentId, int diagnosisId, int treatmentId) {
        this.appointmentId = appointmentId;
        this.diagnosisId = diagnosisId;
        this.treatmentId = treatmentId;
    }

    public MedicalRecord(int id, int appointmentId, int diagnosisId, int treatmentId) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.diagnosisId = diagnosisId;
        this.treatmentId = treatmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalRecord)) {
            return false;
        }
        MedicalRecord that = (MedicalRecord) o;
        return getId() == that.getId() && getAppointmentId() == that.getAppointmentId()
            && getDiagnosisId() == that.getDiagnosisId()
            && getTreatmentId() == that.getTreatmentId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAppointmentId(), getDiagnosisId(), getTreatmentId());
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
            "id=" + id +
            ", appointmentId=" + appointmentId +
            ", diagnosisId=" + diagnosisId +
            ", treatmentId=" + treatmentId +
            '}';
    }
}
