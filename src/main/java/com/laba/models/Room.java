package com.laba.models;

import java.util.Objects;

public class Room {

    private int id;
    private String roomNumber;
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
