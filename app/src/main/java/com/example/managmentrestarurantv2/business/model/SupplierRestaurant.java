package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class SupplierRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;

    Map<String, ContacInformation> listContactInformation;
    Map<String, Product> listProducts;
    String variable;
    String variable1;
    String variable2;

    public SupplierRestaurant() {
    }

    public SupplierRestaurant(Map<String, ContacInformation> listContactInformation, Map<String
            , Product> listProducts, String variable, String variable1, String variable2) {
        this.listContactInformation = listContactInformation;
        this.listProducts = listProducts;
        this.variable = variable;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public Map<String, ContacInformation> getListContactInformation() {
        return listContactInformation;
    }

    public void setListContactInformation(Map<String, ContacInformation> listContactInformation) {
        this.listContactInformation = listContactInformation;
    }

    public Map<String, Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(Map<String, Product> listProducts) {
        this.listProducts = listProducts;
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
        SupplierRestaurant that = (SupplierRestaurant) o;
        return Objects.equals(listContactInformation, that.listContactInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listContactInformation);
    }

    @Override
    public String toString() {
        return "SupplierRestaurant{" +
                "listContactInformation=" + listContactInformation +
                ", listProducts=" + listProducts +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
