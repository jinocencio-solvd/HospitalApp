package com.laba.model;

import java.util.Objects;

public class MedicationType {
    private int id;
    private String medicationType;

    public MedicationType(int id, String medicationType) {
        this.id = id;
        this.medicationType = medicationType;
    }

    public MedicationType(String medicationType) {
        this.medicationType = medicationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(String medicationType) {
        this.medicationType = medicationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicationType)) {
            return false;
        }
        MedicationType that = (MedicationType) o;
        return getId() == that.getId() && Objects.equals(getMedicationType(),
            that.getMedicationType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMedicationType());
    }

    @Override
    public String toString() {
        return "MedicationType{" +
            "id=" + id +
            ", medicationType='" + medicationType + '\'' +
            '}';
    }
}
