package com.laba.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class Staff {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("person")
    @XmlElement(name = "person", type = Person.class)
    private Person person;

    public Staff() {
        // Default Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        return getId() == staff.getId() && Objects.equals(person, staff.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), person);
    }

    @Override
    public String toString() {
        return "Staff{" +
            "id=" + id +
            ", person=" + person +
            '}';
    }

}
