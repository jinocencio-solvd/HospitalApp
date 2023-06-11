package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "treatment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Treatment {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "treatment_name")
    private String treatmentName;

    public Treatment() {
        // Default Constructor
    }

    public Treatment(int id, String treatmentName) {
        this.id = id;
        this.treatmentName = treatmentName;
    }

    public Treatment(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Treatment)) {
            return false;
        }
        Treatment treatment = (Treatment) o;
        return getId() == treatment.getId() && Objects.equals(getTreatmentName(),
            treatment.getTreatmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTreatmentName());
    }

    @Override
    public String toString() {
        return "Treatment{" +
            "id=" + id +
            ", treatmentName='" + treatmentName + '\'' +
            '}';
    }
}
