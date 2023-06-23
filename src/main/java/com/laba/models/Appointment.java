package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.laba.utils.json.DateAdapterJSON;
import com.laba.utils.json.TimeAdapterJSON;
import com.laba.utils.xml.jaxb.DateAdapter;
import com.laba.utils.xml.jaxb.TimeAdapter;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "appointment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("patient")
    @XmlElement(name = "patient", type = Patient.class)
    private Patient patient;


    @JsonProperty("clinician")
    @XmlElement(name = "clinician", type = Clinician.class)
    private Clinician clinician;

    @JsonProperty("room")
    @XmlElement(name = "room", type = Room.class)
    private Room room;

    @JsonProperty("date")
    @XmlElement(name = "date")
    @JsonSerialize(using = DateAdapterJSON.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date appointmentDate;

    @JsonProperty("time")
    @XmlElement(name = "time")
    @JsonSerialize(using = TimeAdapterJSON.class)
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Time appointmentTime;

    public Appointment() {
        // Empty Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Clinician getClinician() {
        return clinician;
    }

    public void setClinician(Clinician clinician) {
        this.clinician = clinician;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment)) {
            return false;
        }
        Appointment that = (Appointment) o;
        return getId() == that.getId() && Objects.equals(getPatient(), that.getPatient())
            && Objects.equals(getClinician(), that.getClinician())
            && Objects.equals(getRoom(), that.getRoom()) && Objects.equals(
            getAppointmentDate(), that.getAppointmentDate()) && Objects.equals(
            getAppointmentTime(), that.getAppointmentTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPatient(), getClinician(), getRoom(), getAppointmentDate(),
            getAppointmentTime());
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + id +
            ", patient=" + patient +
            ", clinician=" + clinician +
            ", room=" + room +
            ", appointmentDate=" + appointmentDate +
            ", appointmentTime=" + appointmentTime +
            '}';
    }

}
