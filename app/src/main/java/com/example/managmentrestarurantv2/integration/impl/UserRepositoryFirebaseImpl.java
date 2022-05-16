package com.example.managmentrestarurantv2.integration.impl;

import android.content.Context;
import androidx.annotation.NonNull;

import com.example.managmentrestarurantv2.business.model.User;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.UserRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class UserRepositoryFirebaseImpl implements UserRepository {
	
	public static User user = new User();

	final String ref = "url de la base de datos";
	final String defecto = "users/";

	DatabaseReference databaseReference;
	FirebaseAuth mAuth;

	
	public UserRepositoryFirebaseImpl() {
		super();
		if (user != null){

		}else {
			user.setEmail(defecto);
			user.setId(defecto);
			user.setTelefono(defecto);
			user.setType(defecto);
			user.setVariable1(defecto);
			user.setVariable2(defecto);
		}
	}

	public UserRepositoryFirebaseImpl(User user) {
		super();
		UserRepositoryFirebaseImpl.user = user;
	}

	@Override
	public void create(User user) {
		// Cuando se crea el usuario en primera instancia el campo id se utilizara para grabar el password
		// una vez creado el usuario ya tendremos su identifiacado y lo añadiremos al campo correcto antes de ser
		//grabado en la BD
		final Boolean[] succes = new Boolean[1];
		mAuth = FirebaseAuth.getInstance();
		mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getId())
				.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					user.setId(mAuth.getUid());
					UserRepositoryFirebaseImpl.user = user;
					update(user);
					succes[0] = true;
				} else {
					succes[0] = false;
				}
			}
		});
	}

	@Override
	public void delete(String idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		databaseReference = FirebaseDatabase.getInstance().getReference();
		databaseReference.child("Users")
				.child(user.getId())
				.child("Profile")
				.setValue(user);
	}

	@Override
	public void read(String idUser, final CallBackFirebase callBackFirebase) {
		databaseReference = FirebaseDatabase.getInstance().getReference();
		databaseReference.child("Users")
				.child(idUser)
				.child("Profile")
				.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				callBackFirebase.onSuccess(snapshot);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError error) {

			}
		});

	}

}