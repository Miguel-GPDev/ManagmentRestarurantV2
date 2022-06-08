package com.example.managmentrestarurantv2.business.model;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String email;
	private String telefono;
	private String  type;
	private String variable1;
	private String variable2;
			
	public User() {
		super();
	}

	public User(String id, String email, String telefono, String type, String variable1, String variable2) {
		this.id = id;
		this.email = email;
		this.telefono = telefono;
		this.type = type;
		this.variable1 = variable1;
		this.variable2 = variable2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVariable1() {
		return variable1;
	}

	public void setVariable1(String variable1) {
		this.variable1 = variable1;
	}

	public String getDateContract() {
		return variable2;
	}

	public void setDateContract(String dateContract) {
		this.variable2 = dateContract;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", email='" + email + '\'' +
				", telefono='" + telefono + '\'' +
				", type='" + type + '\'' +
				", variable1='" + variable1 + '\'' +
				", variable2='" + variable2 + '\'' +
				'}';
	}
}
