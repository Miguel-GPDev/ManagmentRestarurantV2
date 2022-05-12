package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Drink implements Serializable {
    private static final long serialVersionUID = 1L;

    String idDrink;
    String name;
    Double price;
    int amount;
    Map<String, Product> listIngredients;
    Boolean status;
    String dateCreation;
    String varibale;
    String variable1;
    String variable2;

    public Drink() {
    }

    public Drink(String idDrink, String name, Double price, int amount, Map<String
            , Product> listIngredients, Boolean status, String dateCreation, String varibale
            , String variable1, String variable2) {
        this.idDrink = idDrink;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.listIngredients = listIngredients;
        this.status = status;
        this.dateCreation = dateCreation;
        this.varibale = varibale;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getVaribale() {
        return varibale;
    }

    public void setVaribale(String varibale) {
        this.varibale = varibale;
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
        Drink drink = (Drink) o;
        return Objects.equals(idDrink, drink.idDrink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDrink);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "idDrink='" + idDrink + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", listIngredients=" + listIngredients +
                ", status=" + status +
                ", dateCreation='" + dateCreation + '\'' +
                ", varibale='" + varibale + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
