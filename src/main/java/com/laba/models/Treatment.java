package com.laba.models;

import java.util.Objects;

public class Treatment {
    private int id;
    private String treatmentName;

    public Treatment() {
        // Default Constructor
    }


    public Treatment(int id, String treatmentName) {
        this.id = id;
        this.treatmentName = treatmentName;
    }

    public Treatment(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Treatment)) {
            return false;
        }
        Treatment treatment = (Treatment) o;
        return getId() == treatment.getId() && Objects.equals(getTreatmentName(),
            treatment.getTreatmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTreatmentName());
    }

    @Override
    public String toString() {
        return "Treatment{" +
            "id=" + id +
            ", treatmentName='" + treatmentName + '\'' +
            '}';
    }
}
