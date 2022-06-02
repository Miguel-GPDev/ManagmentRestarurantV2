package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Kitchen implements Serializable {
    private static final long serialVersionUID = 1L;

    String idKitchen;
    String name;
    String size;
    String nWorkers;
    Boolean open;
    String idRestaurant;
    String variable1;
    String variable2;

    public Kitchen() {
    }

    public Kitchen(String idKitchen, String name, String size, String nWorkers
            , Boolean open, String idRestaurant, String variable1, String variable2) {
        this.idKitchen = idKitchen;
        this.name = name;
        this.size = size;
        this.nWorkers = nWorkers;
        this.open = open;
        this.idRestaurant = idRestaurant;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdKitchen() {
        return idKitchen;
    }

    public void setIdKitchen(String idKitchen) {
        this.idKitchen = idKitchen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getnWorkers() {
        return nWorkers;
    }

    public void setnWorkers(String nWorkers) {
        this.nWorkers = nWorkers;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kitchen kitchen = (Kitchen) o;
        return Objects.equals(idKitchen, kitchen.idKitchen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKitchen);
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "idKitchen='" + idKitchen + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", nWorkers='" + nWorkers + '\'' +
                ", available=" + open +
                ", variable='" + idRestaurant + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
