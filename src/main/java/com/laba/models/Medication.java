package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medication")
@XmlAccessorType(XmlAccessType.FIELD)
public class Medication {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("medication_name")
    @XmlElement(name = "medication_name")
    private String medicationName;

    @JsonProperty("medication_types_id")
    @XmlElement(name = "medication_types_id")
    private int medicationTypesId;

    public Medication() {
        // Default Constructor
    }

    public Medication(int id, String medicationName, int medicationTypesId) {
        this.id = id;
        this.medicationName = medicationName;
        this.medicationTypesId = medicationTypesId;
    }

    public Medication(String medicationName, int medicationTypesId) {
        this.medicationName = medicationName;
        this.medicationTypesId = medicationTypesId;
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

    public int getMedicationTypesId() {
        return medicationTypesId;
    }

    public void setMedicationTypesId(int medicationTypesId) {
        this.medicationTypesId = medicationTypesId;
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
        return getId() == that.getId() && getMedicationTypesId() == that.getMedicationTypesId()
            && Objects.equals(getMedicationName(), that.getMedicationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMedicationName(), getMedicationTypesId());
    }

    @Override
    public String toString() {
        return "Medication{" +
            "id=" + id +
            ", medicationName='" + medicationName + '\'' +
            ", medicationTypesId=" + medicationTypesId +
            '}';
    }

}
