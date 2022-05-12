package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Objects;

public class ContacInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    String id;
    String name;
    String telf;
    String email;
    String details;
    String information;
    String variable;
    String variable1;
    String variable2;

    public ContacInformation() {
    }

    public ContacInformation(String id, String name, String telf, String email
            , String details, String information, String variable
            , String variable1, String variable2) {
        this.id = id;
        this.name = name;
        this.telf = telf;
        this.email = email;
        this.details = details;
        this.information = information;
        this.variable = variable;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContacInformation that = (ContacInformation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContacInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", telf='" + telf + '\'' +
                ", email='" + email + '\'' +
                ", details='" + details + '\'' +
                ", information='" + information + '\'' +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
