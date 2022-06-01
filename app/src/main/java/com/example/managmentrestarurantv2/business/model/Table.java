package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Table implements Serializable {
    private static final long serialVersionUID = 1L;

    String idMesa;
    Map<String, Count> listCount ;
    Map<String, Booking> listBooking;
    Boolean union;
    int size;
    String idRestaurant;
    Boolean booking;
    Boolean location; // interio o exterior
    String variable2;

    public Table() {
    }

    public Table(String idMesa, Map<String, Count> listCount, Map<String, Booking> listBooking
            , Boolean union, int size, String idRestaurant, Boolean booking, Boolean location, String variable2) {
        this.idMesa = idMesa;
        this.listCount = listCount;
        this.listBooking = listBooking;
        this.union = union;
        this.size = size;
        this.idRestaurant = idRestaurant;
        this.booking = booking;
        this.location = location;
        this.variable2 = variable2;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public Map<String, Count> getListCount() {
        return listCount;
    }

    public void setListCount(Map<String, Count> listCount) {
        this.listCount = listCount;
    }

    public Map<String, Booking> getListBooking() {
        return listBooking;
    }

    public void setListBooking(Map<String, Booking> listBooking) {
        this.listBooking = listBooking;
    }

    public Boolean getUnion() {
        return union;
    }

    public void setUnion(Boolean union) {
        this.union = union;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public Boolean getBooking() {
        return booking;
    }

    public void setBooking(Boolean booking) {
        this.booking = booking;
    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
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
        Table table = (Table) o;
        return Objects.equals(idMesa, table.idMesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMesa);
    }

    @Override
    public String toString() {
        return "Table{" +
                "idMesa='" + idMesa + '\'' +
                ", listCount=" + listCount +
                ", listBooking=" + listBooking +
                ", union=" + union +
                ", size=" + size +
                ", type='" + idRestaurant + '\'' +
                ", variable='" + booking + '\'' +
                ", variable1='" + location + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
