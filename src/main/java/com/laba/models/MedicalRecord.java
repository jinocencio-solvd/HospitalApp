package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medical_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalRecord {


    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("appointment_id")
    @XmlElement(name = "appointment_id")
    private int appointmentId;

    @JsonProperty("diagnosis_id")
    @XmlElement(name = "diagnosis_id")
    private int diagnosisId;

    @JsonProperty("treatment_id")
    @XmlElement(name = "treatment_id")
    private int treatmentId;

    public MedicalRecord() {
        // Default Constructor
    }

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
