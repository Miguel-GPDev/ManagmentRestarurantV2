package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    String idBooking;
    String name;
    int phone;
    int size;
    String day;
    String time;
    String variable;
    String variable1;
    String variable2;

    public Booking() {
    }

    public Booking(String idBooking, String name, int phone, int size, String day
            , String time, String variable, String variable1, String variable2) {
        this.idBooking = idBooking;
        this.name = name;
        this.phone = phone;
        this.size = size;
        this.day = day;
        this.time = time;
        this.variable = variable;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
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
        Booking booking = (Booking) o;
        return Objects.equals(idBooking, booking.idBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", size=" + size +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
