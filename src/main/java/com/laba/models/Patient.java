package com.laba.model;

import java.sql.Date;

public class Patient {
    private int id;
    private int person_id;

    public Patient(int id, int person_id) {
        this.id = id;
        this.person_id = person_id;
    }

    public Patient(int person_id) {
        this.person_id = person_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

}
