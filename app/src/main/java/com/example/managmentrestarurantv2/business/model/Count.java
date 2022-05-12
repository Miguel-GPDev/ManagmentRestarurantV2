package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Count implements Serializable {
    private static final long serialVersionUID = 1L;

    String idCount;
    String idTable;
    String day;
    String time;
    String size;
    String status;
    Map<String, Plate> listPlates;
    Map<String, Drink> listDrinks;
    Double total;
    String variable;
    String variable1;
    String variable2;

    public Count() {
    }

    public Count(String idCount, String idTable, String day, String time, String size, String status
            , Map<String, Plate> listPlates, Map<String, Drink> listDrinks, Double total, String variable
            , String variable1, String variable2) {
        this.idCount = idCount;
        this.idTable = idTable;
        this.day = day;
        this.time = time;
        this.size = size;
        this.status = status;
        this.listPlates = listPlates;
        this.listDrinks = listDrinks;
        this.total = total;
        this.variable = variable;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdCount() {
        return idCount;
    }

    public void setIdCount(String idCount) {
        this.idCount = idCount;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Plate> getListPlates() {
        return listPlates;
    }

    public void setListPlates(Map<String, Plate> listPlates) {
        this.listPlates = listPlates;
    }

    public Map<String, Drink> getListDrinks() {
        return listDrinks;
    }

    public void setListDrinks(Map<String, Drink> listDrinks) {
        this.listDrinks = listDrinks;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        Count count = (Count) o;
        return Objects.equals(idCount, count.idCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCount);
    }

    @Override
    public String toString() {
        return "Count{" +
                "idCount='" + idCount + '\'' +
                ", idTable='" + idTable + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", listPlates=" + listPlates +
                ", listDrinks=" + listDrinks +
                ", total=" + total +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
