package com.example.managmentrestarurantv2.business.model;

public class Worker extends User {
	private static final long serialVersionUID = 1L;
	
	String nif;
	String name;
	String surname1;
	String surname2;
	String address;
	int contract; //horas de contrato
	String charge;
	String idRestaurant;
	String state;
	String workPlace;
	String idBoss;
	String variable2;

	public Worker() {
	}

	public Worker(String nif, String name, String surname1, String surname2
			, String address, int contract, String charge, String idRestaurant
			, String state, String workPlace, String idBoss, String variable2) {
		this.nif = nif;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.address = address;
		this.contract = contract;
		this.charge = charge;
		this.idRestaurant = idRestaurant;
		this.state = state;
		this.workPlace = workPlace;
		this.idBoss = idBoss;
		this.variable2 = variable2;
	}

	public Worker(String id_Usuario, String email, String telefono, String nif
			, String name, String surname1, String surname2, String address
			, int contract, String charge, String idRestaurant, String state
			, String workPlace, String idBoss, String variable2) {
		super(id_Usuario, email, telefono);
		this.nif = nif;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.address = address;
		this.contract = contract;
		this.charge = charge;
		this.idRestaurant = idRestaurant;
		this.state = state;
		this.workPlace = workPlace;
		this.idBoss = idBoss;
		this.variable2 = variable2;
	}

	public Worker(String id_Usuario, String email, String telefono) {
		super(id_Usuario, email, telefono);
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContract() {
		return contract;
	}

	public void setContract(int contract) {
		this.contract = contract;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(String idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getIdBoss() {
		return idBoss;
	}

	public void setIdBoss(String idBoss) {
		this.idBoss = idBoss;
	}

	public String getVariable2() {
		return variable2;
	}

	public void setVariable2(String variable2) {
		this.variable2 = variable2;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"nif='" + nif + '\'' +
				", name='" + name + '\'' +
				", surname1='" + surname1 + '\'' +
				", surname2='" + surname2 + '\'' +
				", address='" + address + '\'' +
				", contract=" + contract +
				", charge='" + charge + '\'' +
				", idRestaurant='" + idRestaurant + '\'' +
				", state='" + state + '\'' +
				", variable='" + workPlace + '\'' +
				", variable1='" + idBoss + '\'' +
				", variable2='" + variable2 + '\'' +
				'}';
	}
}
