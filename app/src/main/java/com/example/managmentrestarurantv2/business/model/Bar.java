package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Bar implements Serializable {
    private static final long serialVersionUID = 1L;

    String idBar;
    Map<String, Count> listCount ;
    Map<String, Booking> listBooking;
    Boolean union;
    int size;
    Map<String,Seat > seatList;
    String idRestaurant; // interio o exterior
    Boolean booking;
    Boolean location; // true = Interior False = Exterior
    String variable2;

    public Bar() {
    }

    public Bar(String idBar, Map<String, Count> listCount, Map<String
            , Booking> listBooking
            , Boolean union, int size, Map<String, Seat> seatList
            , String idRestaurant, Boolean booking, Boolean location, String variable2) {
        this.idBar = idBar;
        this.listCount = listCount;
        this.listBooking = listBooking;
        this.union = union;
        this.size = size;
        this.seatList = seatList;
        this.idRestaurant = idRestaurant;
        this.booking = booking;
        this.location = location;
        this.variable2 = variable2;
    }

    public String getIdBar() {
        return idBar;
    }

    public void setIdBar(String idBar) {
        this.idBar = idBar;
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

    public Map<String, Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(Map<String, Seat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(idBar, bar.idBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBar);
    }

    @Override
    public String toString() {
        return "Bar{" +
                "idBar='" + idBar + '\'' +
                ", listCount=" + listCount +
                ", listBooking=" + listBooking +
                ", union=" + union +
                ", size=" + size +
                ", type='" + idRestaurant + '\'' +
                ", Booking=" + booking +
                ", location=" + location +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
