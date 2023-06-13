package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medication_type")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicationType {


    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "medication_type")
    private String medicationType;

    public MedicationType() {
        // Default Constructor
    }

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
