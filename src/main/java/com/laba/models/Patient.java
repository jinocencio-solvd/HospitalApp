package com.laba.models;

public class Patient {

    private int id;
    private int personId;

    public Patient() {
        // Default Constructor
    }

    public Patient(int id, int personId) {
        this.id = id;
        this.personId = personId;
    }

    public Patient(int personId) {
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

}
