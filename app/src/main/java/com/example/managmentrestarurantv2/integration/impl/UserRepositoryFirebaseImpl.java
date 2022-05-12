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

import java.util.concurrent.Executor;


public class UserRepositoryFirebaseImpl implements UserRepository {
	
	public static User user = new User();

	final String ref = "url de la base de datos";
	final String defecto = "users/";

	DatabaseReference databaseReference;
	FirebaseAuth mAuth;
	Context context;

	
	public UserRepositoryFirebaseImpl() {
		super();
		if (user != null){

		}else {
			user.setEmail(defecto);
			user.setId_Usuario(defecto);
			user.setTelefono(defecto);
		}
	}

	public UserRepositoryFirebaseImpl(User user) {
		super();
		UserRepositoryFirebaseImpl.user = user;
	}

	@Override
	public Boolean create(User user) {
		// Cuando se crea el usuario en primera instancia el campo id se utilizara para grabar el password
		// una vez creado el usuario ya tendremos su identifiacado y lo añadiremos al campo correcto antes de ser
		//grabado en la BD
		final Boolean[] succes = new Boolean[1];
		mAuth = FirebaseAuth.getInstance();
		mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getId_Usuario())
				.addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					user.setId_Usuario(mAuth.getUid());
					UserRepositoryFirebaseImpl.user = user;
					update(user);
					succes[0] = true;
				} else {
					succes[0] = false;
				}
			}
		});
		return succes[0];
	}

	@Override
	public void delete(String idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		databaseReference = FirebaseDatabase.getInstance().getReference();
		databaseReference.child(ref)
				.child(user.getId_Usuario())
				.child("profile")
				.setValue(user);
	}

	@Override
	public void read(String idUser, final CallBackFirebase callBackFirebase) {
		databaseReference = FirebaseDatabase.getInstance().getReference();
		databaseReference.child(ref)
				.child(idUser)
				.child("profile")
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