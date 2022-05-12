package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Plate implements Serializable {
    private static final long serialVersionUID = 1L;

    String idPlate;
    String name;
    Double price;
    int amount;
    Map<String, Product> listIngredients;
    Boolean available;
    String dateCreation;
    String status;
    String variable1;
    String variable2;

    public Plate() {
    }

    public Plate(String idPlate, String name, Double price, int amount
            , Map<String, Product> listIngredients, Boolean available
            , String dateCreation, String status, String variable1
            , String variable2) {
        this.idPlate = idPlate;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.listIngredients = listIngredients;
        this.available = available;
        this.dateCreation = dateCreation;
        this.status = status;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Map<String, Product> getListIngredients() {
        return listIngredients;
    }

    public void setListIngredients(Map<String, Product> listIngredients) {
        this.listIngredients = listIngredients;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Plate plate = (Plate) o;
        return Objects.equals(idPlate, plate.idPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlate);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "idPlate='" + idPlate + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", listIngredients=" + listIngredients +
                ", status=" + available +
                ", dateCreation='" + dateCreation + '\'' +
                ", varibale='" + status + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
