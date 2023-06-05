package com.laba.model;

import java.util.Objects;

public class Profession {

    private int id;
    private String profession;

    public Profession(int id, String profession) {
        this.id = id;
        this.profession = profession;
    }

    public Profession(String profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Profession)) {
            return false;
        }
        Profession that = (Profession) o;
        return getId() == that.getId() && Objects.equals(getProfession(),
            that.getProfession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfession());
    }

    @Override
    public String toString() {
        return "ProfessionDAO{" +
            "id=" + id +
            ", profession='" + profession + '\'' +
            '}';
    }
}

