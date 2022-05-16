package com.example.managmentrestarurantv2.business.model;

import java.util.Map;

public class Client extends User {

	private static final long serialVersionUID = 1L;
	
	private double debt;
	private double credit;
	private boolean VIP;
	private Map<String, Preference> listPreference ;
	private String variable1;
	private String vaiable2;
		
	public Client() {
		super();
	}

	public Client(double debt, double credit, boolean VIP, Map<String, Preference> listPreference, String variable1, String vaiable2) {
		this.debt = debt;
		this.credit = credit;
		this.VIP = VIP;
		this.listPreference = listPreference;
		this.variable1 = variable1;
		this.vaiable2 = vaiable2;
	}

	public Client(String id, String email, String telefono, String type
			, String variable1, String variable2) {
		super(id, email, telefono, type, variable1, variable2);
	}

	public Client(String id, String email, String telefono, String type, String variable1
			, String variable2, double debt, double credit, boolean VIP, Map<String
			, Preference> listPreference, String variable11, String vaiable2) {
		super(id, email, telefono, type, variable1, variable2);
		this.debt = debt;
		this.credit = credit;
		this.VIP = VIP;
		this.listPreference = listPreference;
		this.variable1 = variable11;
		this.vaiable2 = vaiable2;
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

	public void setVIP(boolean VIP) {
		this.VIP = VIP;
	}

	public Map<String, Preference> getListPreference() {
		return listPreference;
	}

	public void setListPreference(Map<String, Preference> listPreference) {
		this.listPreference = listPreference;
	}

	@Override
	public String getVariable1() {
		return variable1;
	}

	@Override
	public void setVariable1(String variable1) {
		this.variable1 = variable1;
	}

	public String getVaiable2() {
		return vaiable2;
	}

	public void setVaiable2(String vaiable2) {
		this.vaiable2 = vaiable2;
	}

	@Override
	public String toString() {
		return "Client{" +
				super.toString() +
				"debt=" + debt +
				", credit=" + credit +
				", VIP=" + VIP +
				", listPreference=" + listPreference +
				", variable1='" + variable1 + '\'' +
				", vaiable2='" + vaiable2 + '\'' +
				'}';
	}
}
