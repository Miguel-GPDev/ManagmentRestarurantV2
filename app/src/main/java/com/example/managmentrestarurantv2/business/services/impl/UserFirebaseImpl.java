package com.example.managmentrestarurantv2.business.services.impl;


import com.example.managmentrestarurantv2.business.model.User;
import com.example.managmentrestarurantv2.business.services.UserServices;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.UserRepository;
import com.example.managmentrestarurantv2.integration.impl.UserRepositoryFirebaseImpl;
import com.google.firebase.database.DataSnapshot;


public class UserFirebaseImpl implements UserServices {
	
	UserRepository userRepository;
	
	public UserFirebaseImpl() {
		this.userRepository = new UserRepositoryFirebaseImpl();
	}

	@Override
	public Boolean create(User user) {

		return userRepository.create(user);
	}

	@Override
	public void delete(String idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(String idUser) {
		final User[] user = {new User()};
		userRepository.read(idUser, new CallBackFirebase() {
			@Override
			public void onSuccess(DataSnapshot dataSnapshot) {
				user[0] = dataSnapshot.getValue(User.class);
			}

			@Override
			public void onStart() {

			}

			@Override
			public void onFailure() {

			}
		});
		return user[0];
	}
}
