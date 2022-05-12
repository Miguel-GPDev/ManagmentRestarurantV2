package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    String idProduct;
    String name;
    String brand;
    Map<String, SupplierRestaurant> listSuppliers;
    Double amount;
    String typeMeasurement;
    Double price;
    Double profit;
    Double tax;
    Map<String, String> listPhotos;
    String categoryProduct;
    String variable;
    String variable1;
    String variable2;

    public Product() {
    }

    public Product(String idProduct, String name, String brand, Map<String, SupplierRestaurant> listSuppliers
            , Double amount, String typeMeasurement, Double price, Double profit, Double tax, Map<String
            , String> listPhotos, String categoryProduct, String variable, String variable1, String variable2) {
        this.idProduct = idProduct;
        this.name = name;
        this.brand = brand;
        this.listSuppliers = listSuppliers;
        this.amount = amount;
        this.typeMeasurement = typeMeasurement;
        this.price = price;
        this.profit = profit;
        this.tax = tax;
        this.listPhotos = listPhotos;
        this.categoryProduct = categoryProduct;
        this.variable = variable;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Map<String, SupplierRestaurant> getListSuppliers() {
        return listSuppliers;
    }

    public void setListSuppliers(Map<String, SupplierRestaurant> listSuppliers) {
        this.listSuppliers = listSuppliers;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTypeMeasurement() {
        return typeMeasurement;
    }

    public void setTypeMeasurement(String typeMeasurement) {
        this.typeMeasurement = typeMeasurement;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Map<String, String> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(Map<String, String> listPhotos) {
        this.listPhotos = listPhotos;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
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
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", listSuppliers=" + listSuppliers +
                ", amount=" + amount +
                ", typeMeasurement='" + typeMeasurement + '\'' +
                ", price=" + price +
                ", profit=" + profit +
                ", tax=" + tax +
                ", listPhotos=" + listPhotos +
                ", categoryFood='" + categoryProduct + '\'' +
                ", variable='" + variable + '\'' +
                ", variable1='" + variable1 + '\'' +
                ", variable2='" + variable2 + '\'' +
                '}';
    }
}
