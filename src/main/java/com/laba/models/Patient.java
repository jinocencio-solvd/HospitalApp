package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("person_id")
    @XmlElement(name = "person_id")
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
