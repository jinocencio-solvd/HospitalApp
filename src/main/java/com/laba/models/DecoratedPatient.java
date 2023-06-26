package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class DecoratedPatient {

    protected Patient patient;

    @JsonProperty("medical_records")
    @XmlElementWrapper(name = "medical_records")
    @XmlElement(name = "medical_record", type = MedicalRecord.class)
    private List<MedicalRecord> medicalRecords;

    public DecoratedPatient(Patient patient) {
        this.patient = patient;
    }

    public List<MedicalRecord> getPatientMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }


    @Override
    public String toString() {
        return "DecoratedPatient{" +
            "patient=" + patient +
            ", medicalRecords=" + medicalRecords +
            '}';
    }

}
