package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "diagnosis")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diagnosis {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "diagnosis_code")
    private String diagnosisCode;

    @XmlElement(name = "description")
    private String description;

    public Diagnosis() {
        // Default Constructor
    }

    public Diagnosis(int id, String diagnosisCode, String description) {
        this.id = id;
        this.diagnosisCode = diagnosisCode;
        this.description = description;
    }

    public Diagnosis(String diagnosisCode, String description) {
        this.diagnosisCode = diagnosisCode;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Diagnosis)) {
            return false;
        }
        Diagnosis diagnosis = (Diagnosis) o;
        return getId() == diagnosis.getId() && Objects.equals(getDiagnosisCode(),
            diagnosis.getDiagnosisCode()) && Objects.equals(getDescription(),
            diagnosis.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiagnosisCode(), getDescription());
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
            "id=" + id +
            ", diagnosis_code='" + diagnosisCode + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}

