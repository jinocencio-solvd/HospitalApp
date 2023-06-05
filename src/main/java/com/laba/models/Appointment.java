package com.laba.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Appointment {

    private int id;
    private int patientId;
    private int clinicianId;
    private int roomId;
    private Date date;
    private Time time;

    public Appointment() {
        // Default Constructor
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
