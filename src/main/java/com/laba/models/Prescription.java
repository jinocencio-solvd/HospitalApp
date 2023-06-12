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
    private int prescriptionId;

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
    private Date startDate;

    @JsonProperty("prescription_expiration_date")
    @XmlElement(name = "prescription_expiration_date")
    @JsonSerialize(using = DateAdapterJSON.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date expirationDate;

    public Prescription() {
        // Default Constructor
    }


    public Prescription(int prescriptionId, int treatmentId, int medicationId, String dosage,
        Date startDate, Date expirationDate) {
        this.prescriptionId = prescriptionId;
        this.treatmentId = treatmentId;
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Prescription(int treatmentId, int medicationId, String dosage, Date startDate,
        Date expirationDate) {
        this.treatmentId = treatmentId;
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prescription)) {
            return false;
        }
        Prescription that = (Prescription) o;
        return getPrescriptionId() == that.getPrescriptionId()
            && getTreatmentId() == that.getTreatmentId()
            && getMedicationId() == that.getMedicationId()
            && Objects.equals(getDosage(), that.getDosage()) && Objects.equals(
            getStartDate(), that.getStartDate()) && Objects.equals(getExpirationDate(),
            that.getExpirationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrescriptionId(), getTreatmentId(), getMedicationId(), getDosage(),
            getStartDate(), getExpirationDate());
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Prescription{" +
            "prescriptionId=" + prescriptionId +
            ", treatmentId=" + treatmentId +
            ", medicationId=" + medicationId +
            ", dosage='" + dosage + '\'' +
            ", startDate=" + startDate +
            ", expirationDate=" + expirationDate +
            '}';
    }
}

