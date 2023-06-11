package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medication")
@XmlAccessorType(XmlAccessType.FIELD)
public class Medication {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "medication_name")
    private String medicationName;

    @XmlElement(name = "medication_types_id")
    private int medicationTypeId;

    public Medication() {
        // Default Constructor
    }

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
