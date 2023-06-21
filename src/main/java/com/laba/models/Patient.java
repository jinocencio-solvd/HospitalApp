package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient extends Person {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private Integer id;

    @JsonProperty("person_id")
    @XmlElement(name = "person_id")
    private int personId;

    @JsonProperty("medical_records")
    @XmlElementWrapper(name = "medical_records")
    @XmlElement(name = "medical_record", type = MedicalRecord.class)
    private List<MedicalRecord> medicalRecords;

    private List<Appointment> appointments;

    private Person person;

    public Patient() {
        // Default Constructor
    }

    public Patient(Integer id, int personId) {
        this.id = id;
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Patient(Integer personId) {
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Patient)) {
            return false;
        }
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId()) && getPersonId() == patient.getPersonId()
            && Objects.equals(getMedicalRecords(), patient.getMedicalRecords())
            && Objects.equals(getPerson(), patient.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPersonId(), getMedicalRecords(), getPerson());
    }

    @Override
    public String toString() {
        return "Patient{" +
            "id=" + id +
            ", personId=" + personId +
            ", medicalRecords=" + medicalRecords +
            ", appointments=" + appointments +
            ", person=" + person +
            '}';
    }
}
