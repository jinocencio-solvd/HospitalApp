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

    @JsonProperty("department_id")
    @XmlElement(name = "department_id")
    private int departmentId;

    public Room() {
        // Default Constructor
    }

    public Room(int id, String roomNumber, int departmentId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.departmentId = departmentId;
    }

    public Room(String roomNumber, int departmentId) {
        this.roomNumber = roomNumber;
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        return getId() == room.getId() && getDepartmentId() == room.getDepartmentId()
            && Objects.equals(getRoomNumber(), room.getRoomNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoomNumber(), getDepartmentId());
    }

    @Override
    public String toString() {
        return "Room{" +
            "id=" + id +
            ", roomNumber='" + roomNumber + '\'' +
            ", departmentId=" + departmentId +
            '}';
    }
}
