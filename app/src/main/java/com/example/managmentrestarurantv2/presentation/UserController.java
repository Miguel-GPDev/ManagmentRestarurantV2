package com.example.managmentrestarurantv2.presentation;


import com.example.managmentrestarurantv2.business.model.User;
import com.example.managmentrestarurantv2.business.services.UserServices;
import com.example.managmentrestarurantv2.business.services.impl.UserFirebaseImpl;

public class UserController {
	
	UserServices userServices = new UserFirebaseImpl();
	
	public Boolean createUser (User user) {
		return null;
	}
	
	public void deleteUser (String idUser) {

	}
	
	public User getUser (String idUser) {
		return null;
	}
}
