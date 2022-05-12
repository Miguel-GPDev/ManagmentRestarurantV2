package com.example.managmentrestarurantv2.business.model;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String email;
	private String telefono;
			
	public User() {
		super();
	}
	
	public User(String id_Usuario, String email, String telefono) {
		super();
		this.id = id_Usuario;
		this.email = email;
		this.telefono = telefono;
	}
	
	public String getId_Usuario() {
		return id;
	}
	
	public void setId_Usuario(String id_Usuario) {
		this.id = id_Usuario;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
}
