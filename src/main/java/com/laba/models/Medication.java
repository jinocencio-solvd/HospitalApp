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

    @JsonProperty("medication_types")
    @XmlElement(name = "medication_types", type = MedicationType.class)
    private MedicationType medicationType;

    public Medication() {
        // Default Constructor
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

    public MedicationType getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(MedicationType medicationType) {
        this.medicationType = medicationType;
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
        return getId() == that.getId() && Objects.equals(getMedicationName(), that.getMedicationName())
            && Objects.equals(getMedicationType(), that.getMedicationType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMedicationName(), getMedicationType());
    }

    @Override
    public String toString() {
        return "Medication{" +
            "id=" + id +
            ", medicationName='" + medicationName + '\'' +
            ", medicationType=" + medicationType +
            '}';
    }
}
