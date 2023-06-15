package com.laba.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
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

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("first_name")
    @XmlElement(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @XmlElement(name = "last_name")
    private String lastName;

    @JsonProperty("dob")
    @XmlElement(name = "dob")
    @JsonSerialize(using = DateAdapterJSON.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "PST")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dob;

    public Person() {
        // Default Constructor
    }

    public Person(int id, String firstName, String lastName, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Person(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonGetter("dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", dob=" + dob +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return getFirstName().equals(person.getFirstName()) && getLastName().equals(
            person.getLastName()) && getDob().toString().equals(person.getDob().toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDob());
    }
}
