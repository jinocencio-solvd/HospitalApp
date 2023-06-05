package com.laba.models;

import java.util.Objects;

public class Diagnosis {

    private int id;
    private String diagnosis_code;
    private String description;

    public Diagnosis(int id, String diagnosis_code, String description) {
        this.id = id;
        this.diagnosis_code = diagnosis_code;
        this.description = description;
    }

    public Diagnosis(String diagnosis_code, String description) {
        this.diagnosis_code = diagnosis_code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosis_code() {
        return diagnosis_code;
    }

    public void setDiagnosis_code(String diagnosis_code) {
        this.diagnosis_code = diagnosis_code;
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
        return getId() == diagnosis.getId() && Objects.equals(getDiagnosis_code(),
            diagnosis.getDiagnosis_code()) && Objects.equals(getDescription(),
            diagnosis.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiagnosis_code(), getDescription());
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
            "id=" + id +
            ", diagnosis_code='" + diagnosis_code + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}

