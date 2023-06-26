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

    @JsonProperty("appointment")
    @XmlElement(name = "appointment", type = Appointment.class)
    private Appointment appointment;

    @JsonProperty("diagnosis")
    @XmlElement(name = "diagnosis", type = Diagnosis.class)
    private Diagnosis diagnosis;

    @JsonProperty("treatment")
    @XmlElement(name = "treatment", type = Treatment.class)
    private Treatment treatment;

    public MedicalRecord() {
        // Default Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
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
        return getId() == that.getId() && Objects.equals(getAppointment(), that.getAppointment())
            && Objects.equals(getDiagnosis(), that.getDiagnosis())
            && Objects.equals(getTreatment(), that.getTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAppointment(), getDiagnosis(), getTreatment());
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
            "id=" + id +
            ", appointment=" + appointment +
            ", diagnosis=" + diagnosis +
            ", treatment=" + treatment +
            '}';
    }
}
