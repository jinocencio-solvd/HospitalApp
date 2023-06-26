package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clinician")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clinician {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("staff")
    @XmlElement(name = "staff", type = Staff.class)
    private Staff staff;

    @JsonProperty("profession")
    @XmlElement(name = "profession", type = Profession.class)
    private Profession profession;

    @JsonProperty("specialization")
    @XmlElement(name = "specialization", type = Specialization.class)
    private Specialization specialization;

    public Clinician() {
        // Default Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Clinician{" +
            "id=" + id +
            ", staff=" + staff +
            ", profession=" + profession +
            ", specialization=" + specialization +
            '}';
    }

}
