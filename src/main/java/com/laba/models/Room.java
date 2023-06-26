package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {

    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("room_number")
    @XmlElement(name = "room_number")
    private String roomNumber;

    @JsonProperty("department")
    @XmlElement(name = "department")
    private Department department;

    public Room() {
        // Default Constructor
    }

    public Room(int id, String roomNumber, Department department) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.department = department;
    }

    public Room(String roomNumber, Department department) {
        this.roomNumber = roomNumber;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return getId() == room.getId() && Objects.equals(getRoomNumber(), room.getRoomNumber())
            && Objects.equals(getDepartment(), room.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoomNumber(), getDepartment());
    }

    @Override
    public String toString() {
        return "Room{" +
            "id=" + id +
            ", roomNumber='" + roomNumber + '\'' +
            ", department=" + department +
            '}';
    }
}
