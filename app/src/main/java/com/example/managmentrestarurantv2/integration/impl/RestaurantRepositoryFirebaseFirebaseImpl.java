package com.example.managmentrestarurantv2.integration.impl;

import androidx.annotation.NonNull;

import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.RestaurantRepositoryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;


public class RestaurantRepositoryFirebaseFirebaseImpl implements RestaurantRepositoryFirebase {
    public static Restaurant restaurant = new Restaurant();
    public static List<Restaurant> listRestaurants = new ArrayList<>();

    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    public RestaurantRepositoryFirebaseFirebaseImpl() {
    }

    @Override
    public Boolean create(Restaurant restaurant) {
        String idRestaurante;
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        idRestaurante =databaseReference.push().getKey();
        return  databaseReference.child("Users")
                .child(mAuth.getUid())
                .child("Restaurants")
                .child(idRestaurante)
                .setValue(restaurant).isSuccessful();
    }

    @Override
    public void read(String idResturant, CallBackFirebase callBackFirebase) {
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(mAuth.getUid())
                .child("Restaurants")
                .child(idResturant)
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

    @Override
    public Boolean update(String idRestaurante) {
        return null;
    }

    @Override
    public Boolean delete(String idRestarurante) {
        String idRestaurante;

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        idRestaurante =databaseReference.push().getKey();
        databaseReference.child("Users")
                .child(mAuth.getUid())
                .child("Restaurants")
                .child(idRestaurante)
                .setValue(null);

        return true;
    }

    @Override
    public void getAll(String idUsuario, final CallBackFirebase callBackFirebase) {
        mAuth = FirebaseAuth.getInstance();
        String idUser = mAuth.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(idUser)
                .child("Restaurants")
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

    @Override
    public void getListName(String idUsuario, CallBackFirebase callBackFirebase) {
        mAuth = FirebaseAuth.getInstance();
        String idUser = mAuth.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(idUser)
                .child("ListRestaurants")
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
