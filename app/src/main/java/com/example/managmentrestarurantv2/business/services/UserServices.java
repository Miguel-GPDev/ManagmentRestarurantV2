package com.example.managmentrestarurantv2.business.services;


import com.example.managmentrestarurantv2.business.model.User;

public interface UserServices {
	
	Boolean create (User user);
	void delete (String idUser);
	void update (User user);
	User read (String idUser);
}
