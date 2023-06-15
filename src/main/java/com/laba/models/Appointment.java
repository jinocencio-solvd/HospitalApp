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

    @JsonProperty("patient_id")
    @XmlElement(name = "patient_id")
    private int patientId;

    @JsonProperty("clinician_id")
    @XmlElement(name = "clinician_id")
    private int clinicianId;

    @JsonProperty("room_id")
    @XmlElement(name = "room_id")
    private int roomId;

    @JsonProperty("date")
    @XmlElement(name = "date")
    @JsonSerialize(using = DateAdapterJSON.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    @JsonProperty("time")
    @XmlElement(name = "time")
    @JsonSerialize(using = TimeAdapterJSON.class)
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Time time;

    public Appointment() {
        // Empty Constructor
    }

    public Appointment(int id, int patientId, int clinicianId, int roomId, Date date,
        Time time) {
        this.id = id;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.roomId = roomId;
        this.date = date;
        this.time = time;
    }

    public Appointment(int patientId, int clinicianId, int roomId, Date date, Time time) {
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.roomId = roomId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getClinicianId() {
        return clinicianId;
    }

    public void setClinicianId(int clinicianId) {
        this.clinicianId = clinicianId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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
        return getId() == that.getId() && getPatientId() == that.getPatientId()
            && getClinicianId() == that.getClinicianId() && getRoomId() == that.getRoomId()
            && Objects.equals(getDate(), that.getDate()) && Objects.equals(
            getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPatientId(), getClinicianId(), getRoomId(), getDate(),
            getTime());
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + id +
            ", patientId=" + patientId +
            ", clinicianId=" + clinicianId +
            ", roomId=" + roomId +
            ", date=" + date +
            ", time=" + time +
            '}';
    }
}
