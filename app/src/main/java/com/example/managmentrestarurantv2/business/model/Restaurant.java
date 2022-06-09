package com.example.managmentrestarurantv2.business.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String idRestaurant;
	private String telephone;
	private String email;
	private Map <String, Table> listTables;
	private Map <String, Worker> listWorkers;
	private Map <String, Kitchen> listKitchen;
	private Map <String, Bar> lisBar;
	private Map <String, Client> listClient;
	private Map <String, MenuRestaurant> listMenus;
	private Map <String, SupplierRestaurant> listSuppliers;
	private Map <String, Booking> listBookings;
	private Map <String, Product> listProducts;
	private String status;
	private String name;
	private String variable2;
	private String variable3;

	public Restaurant() {
		super();
	}

	public Restaurant(String idRestaurant, String telephone, String email, Map<String, Table> listTables,
					  Map<String, Worker> listWorkers, Map<String, Kitchen> listKitchen, Map<String, Bar> lisBar,
					  Map<String, Client> listClient, Map<String, MenuRestaurant> listMenus,
					  Map<String, SupplierRestaurant> listSuppliers, Map<String, Booking> listBookings,
					  Map<String, Product> listProducts, String status, String name, String variable2, String variable3) {
		super();
		this.idRestaurant = idRestaurant;
		this.telephone = telephone;
		this.email = email;
		this.listTables = listTables;
		this.listWorkers = listWorkers;
		this.listKitchen = listKitchen;
		this.lisBar = lisBar;
		this.listClient = listClient;
		this.listMenus = listMenus;
		this.listSuppliers = listSuppliers;
		this.listBookings = listBookings;
		this.listProducts = listProducts;
		this.status = status;
		this.name = name;
		this.variable2 = variable2;
		this.variable3 = variable3;
	}

	public String getIdRestaurant() {
		return idRestaurant;
	}
	
	public void setIdRestaurant(String idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Map<String, Table> getListTables() {
		return listTables;
	}
	
	public void setListTables(Map<String, Table> listTables) {
		this.listTables = listTables;
	}
	public Map<String, Worker> getListWorkers() {
		return listWorkers;
	}
	
	public void setListWorkers(Map<String, Worker> listWorkers) {
		this.listWorkers = listWorkers;
	}
	
	public Map<String, Kitchen> getListKitchen() {
		return listKitchen;
	}
	
	public void setListKitchen(Map<String, Kitchen> listKitchen) {
		this.listKitchen = listKitchen;
	}
	
	public Map<String, Bar> getLisBar() {
		return lisBar;
	}
	
	public void setLisBar(Map<String, Bar> lisBar) {
		this.lisBar = lisBar;
	}
	
	public Map<String, Client> getListClient() {
		return listClient;
	}
	
	public void setListClient(Map<String, Client> listClient) {
		this.listClient = listClient;
	}
	
	public Map<String, MenuRestaurant> getListMenus() {
		return listMenus;
	}
	
	public void setListMenus(Map<String, MenuRestaurant> listMenus) {
		this.listMenus = listMenus;
	}
	
	public Map<String, SupplierRestaurant> getListSuppliers() {
		return listSuppliers;
	}
	
	public void setListSuppliers(Map<String, SupplierRestaurant> listSuppliers) {
		this.listSuppliers = listSuppliers;
	}
	
	public Map<String, Booking> getListBookings() {
		return listBookings;
	}
	
	public void setListBookings(Map<String, Booking> listBookings) {
		this.listBookings = listBookings;
	}
	
	public Map<String, Product> getListProducts() {
		return listProducts;
	}
	
	public void setListProducts(Map<String, Product> listProducts) {
		this.listProducts = listProducts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVariable2() {
		return variable2;
	}

	public void setVariable2(String variable2) {
		this.variable2 = variable2;
	}

	public String getVariable3() {
		return variable3;
	}

	public void setVariable3(String variable3) {
		this.variable3 = variable3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRestaurant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(idRestaurant, other.idRestaurant);
	}

	@Override
	public String toString() {
		return name;
	}
}
