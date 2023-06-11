package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "specialization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Specialization {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "specialization")
    private String specialization;

    public Specialization() {
        // Default Constructor
    }

    public Specialization(int id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public Specialization(String specialization) {
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Specialization)) {
            return false;
        }
        Specialization that = (Specialization) o;
        return getId() == that.getId() && Objects.equals(getSpecialization(),
            that.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSpecialization());
    }

    @Override
    public String toString() {
        return "Specialization{" +
            "id=" + id +
            ", specialization='" + specialization + '\'' +
            '}';
    }
}

