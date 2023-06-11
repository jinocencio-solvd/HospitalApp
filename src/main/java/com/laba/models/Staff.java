package com.laba.models;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class Staff {


    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "person_id")
    private int personId;

    public Staff() {
        // Default Constructor
    }


    public Staff(int id, int personId) {
        this.id = id;
        this.personId = personId;
    }

    public Staff(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        Staff staff = (Staff) o;
        return getId() == staff.getId() && getPersonId() == staff.getPersonId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPersonId());
    }

    @Override
    public String toString() {
        return "Staff{" +
            "id=" + id +
            ", personId=" + personId +
            '}';
    }
}
