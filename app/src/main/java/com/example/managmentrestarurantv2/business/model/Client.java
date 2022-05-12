package com.example.managmentrestarurantv2.business.model;

import java.util.Map;

public class Client extends User {

	private static final long serialVersionUID = 1L;
	
	private double debt;
	private double credit;
	private boolean VIP;
	private Map<String, Preference> listPreference ;
		
	public Client() {
		super();
	}
	
	
	public Client(String id_Usuario, String email, String telefono) {
		super(id_Usuario, email, telefono);
		// TODO Auto-generated constructor stub
	}

	public double getDebt() {
		return debt;
	}
	
	public void setDebt(double debt) {
		this.debt = debt;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public boolean isVIP() {
		return VIP;
	}
	
	public void setVIP(boolean vIP) {
		VIP = vIP;
	}
	
	public Map<String, Preference> getListPreference() {
		return listPreference;
	}
	
	public void setListPreference(Map<String, Preference> listPreference) {
		this.listPreference = listPreference;
	}


	@Override
	public String toString() {
		return "Client [debt=" + debt + ", credit=" + credit + ", VIP=" + VIP + ", listPreference=" + listPreference
				+ ", toString()=" + super.toString() + "]";
	}

}
