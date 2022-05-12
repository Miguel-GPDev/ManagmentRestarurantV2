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
    String type; // interio o exterior
    String variable;
    String variable1;
    String variable2;

    public Table() {
    }

    public Table(String idMesa, Map<String, Count> listCount, Map<String, Booking> listBooking
            , Boolean union, int size, String type, String variable, String variable1, String variable2) {
        this.idMesa = idMesa;
        this.listCount = listCount;
        this.listBooking = listBooking;
        this.union = union;
        this.size = size;
        this.type = type;
        this.variable = variable;
        this.variable1 = variable1;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
