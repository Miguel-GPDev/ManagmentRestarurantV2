package com.example.managmentrestarurantv2.business.services.impl;

import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.services.RestaurantServices;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.RestaurantRepositoryFirebase;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseFirebaseImpl;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFirebaseImpl implements RestaurantServices {

    RestaurantRepositoryFirebase restaurantRepositoryFirebase = new RestaurantRepositoryFirebaseFirebaseImpl();

    @Override
    public Boolean create(Restaurant restaurant) {
        return restaurantRepositoryFirebase.create(restaurant);
    }

    @Override
    public Restaurant read(String idResturant) {
        final Restaurant[] restaurant = {new Restaurant()};
        restaurantRepositoryFirebase.read(idResturant, new CallBackFirebase() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                restaurant[0] = dataSnapshot.getValue(Restaurant.class);

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
        return restaurant[0];
    }

    @Override
    public Boolean update(String idRestaurante) {
        return null;
    }

    @Override
    public Boolean delete(String idRestarurante) {
        return null;
    }

    @Override
    public List<Restaurant> getAll(String idUsuario) {
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantRepositoryFirebase.getAll(idUsuario, new CallBackFirebase() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Restaurant restaurant = new Restaurant();
                    restaurant = dataSnapshot1.getValue(Restaurant.class);
                    restaurantList.add(restaurant);
                }

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
        return restaurantList;
    }
}
