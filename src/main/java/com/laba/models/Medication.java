package com.laba.models;

import java.util.Objects;

public class Medication {

    private int id;
    private String medicationName;
    private int medicationTypeId;

    public Medication(int id, String medicationName, int medicationTypeId) {
        this.id = id;
        this.medicationName = medicationName;
        this.medicationTypeId = medicationTypeId;
    }

    public Medication(String medicationName, int medicationTypeId) {
        this.medicationName = medicationName;
        this.medicationTypeId = medicationTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public int getMedicationTypeId() {
        return medicationTypeId;
    }

    public void setMedicationTypeId(int medicationTypeId) {
        this.medicationTypeId = medicationTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medication)) {
            return false;
        }
        Medication that = (Medication) o;
        return getId() == that.getId() && getMedicationTypeId() == that.getMedicationTypeId()
            && Objects.equals(getMedicationName(), that.getMedicationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMedicationName(), getMedicationTypeId());
    }

    @Override
    public String toString() {
        return "Medication{" +
            "id=" + id +
            ", medicationName='" + medicationName + '\'' +
            ", medicationTypeId=" + medicationTypeId +
            '}';
    }
}
