package com.laba.models;

import java.util.Objects;

public class Staff {

    private int id;
    private int personId;

    public Staff() {
        // Default Constructor
    }


    public Staff(int id, int personId) {
        this.id = id;
        this.personId = personId;
    }

    public Staff(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        Staff staff = (Staff) o;
        return getId() == staff.getId() && getPersonId() == staff.getPersonId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPersonId());
    }

    @Override
    public String toString() {
        return "Staff{" +
            "id=" + id +
            ", personId=" + personId +
            '}';
    }
}
