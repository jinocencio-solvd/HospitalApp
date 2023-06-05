package com.laba.models;

import java.util.Objects;

public class Clinician {

    private int id;
    private int staffId;
    private int professionId;
    private int specializationId;

    public Clinician(int staffId, int professionId, int specializationId) {
        this.staffId = staffId;
        this.professionId = professionId;
        this.specializationId = specializationId;
    }

    public Clinician(int id, int staffId, int professionId, int specializationId) {
        this.id = id;
        this.staffId = staffId;
        this.professionId = professionId;
        this.specializationId = specializationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Clinician)) {
            return false;
        }
        Clinician clinician = (Clinician) o;
        return getId() == clinician.getId() && getStaffId() == clinician.getStaffId()
            && getProfessionId() == clinician.getProfessionId()
            && getSpecializationId() == clinician.getSpecializationId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStaffId(), getProfessionId(), getSpecializationId());
    }

    @Override
    public String toString() {
        return "Clinician{" +
            "id=" + id +
            ", staffId=" + staffId +
            ", professionId=" + professionId +
            ", specializationId=" + specializationId +
            '}';
    }
}
