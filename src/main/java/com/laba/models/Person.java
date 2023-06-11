package com.laba.models;

import com.laba.utils.jaxb.DateAdapter;
import java.sql.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {


    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "first_name")
    private String firstName;

    @XmlAttribute(name = "last_name")
    private String lastName;

    @XmlAttribute(name = "dob")
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
            person.getLastName()) && getDob().equals(person.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDob());
    }
}
