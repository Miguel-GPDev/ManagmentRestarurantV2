package com.example.managmentrestarurantv2.integration;

import com.example.managmentrestarurantv2.business.model.User;

public interface UserRepository {
	
	void create (User user);
	void delete (String idUser);
	void update (User user);
	void read (String idUser, CallBackFirebase callBackFirebase);

}
