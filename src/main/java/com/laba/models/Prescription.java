package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.laba.utils.json.DateAdapterJSON;
import com.laba.utils.xml.jaxb.DateAdapter;
import java.sql.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "prescription")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prescription {

    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("treatment_id")
    @XmlElement(name = "treatment_id")
    private int treatmentId;

    @JsonProperty("medication_id")
    @XmlElement(name = "medication_id")
    private int medicationId;

    @JsonProperty("dosage")
    @XmlElement(name = "dosage")
    private String dosage;

    @JsonProperty("prescription_start_date")
    @XmlElement(name = "prescription_start_date")
    @JsonSerialize(using = DateAdapterJSON.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date prescriptionStartDate;

    @JsonProperty("prescription_expiration_date")
    @XmlElement(name = "prescription_expiration_date")
    @JsonSerialize(using = DateAdapterJSON.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date prescriptionExpirationDate;

    public Prescription() {
        // Default Constructor
    }


    public Prescription(int id, int treatmentId, int medicationId, String dosage,
        Date prescriptionStartDate, Date prescriptionExpirationDate) {
        this.id = id;
        this.treatmentId = treatmentId;
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.prescriptionStartDate = prescriptionStartDate;
        this.prescriptionExpirationDate = prescriptionExpirationDate;
    }

    public Prescription(int treatmentId, int medicationId, String dosage,
        Date prescriptionStartDate,
        Date prescriptionExpirationDate) {
        this.treatmentId = treatmentId;
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.prescriptionStartDate = prescriptionStartDate;
        this.prescriptionExpirationDate = prescriptionExpirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getPrescriptionStartDate() {
        return prescriptionStartDate;
    }

    public void setPrescriptionStartDate(Date prescriptionStartDate) {
        this.prescriptionStartDate = prescriptionStartDate;
    }

    public Date getPrescriptionExpirationDate() {
        return prescriptionExpirationDate;
    }

    public void setPrescriptionExpirationDate(Date prescriptionExpirationDate) {
        this.prescriptionExpirationDate = prescriptionExpirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prescription)) {
            return false;
        }
        Prescription that = (Prescription) o;
        return getId() == that.getId()
            && getTreatmentId() == that.getTreatmentId()
            && getMedicationId() == that.getMedicationId()
            && Objects.equals(getDosage(), that.getDosage()) && Objects.equals(
            getPrescriptionStartDate(), that.getPrescriptionStartDate()) && Objects.equals(
            getPrescriptionExpirationDate(),
            that.getPrescriptionExpirationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTreatmentId(), getMedicationId(), getDosage(),
            getPrescriptionStartDate(), getPrescriptionExpirationDate());
    }

    @Override
    public String toString() {
        return "Prescription{" +
            "id=" + id +
            ", treatmentId=" + treatmentId +
            ", medicationId=" + medicationId +
            ", dosage='" + dosage + '\'' +
            ", prescriptionStartDate=" + prescriptionStartDate +
            ", prescriptionExpirationDate=" + prescriptionExpirationDate +
            '}';
    }

}

