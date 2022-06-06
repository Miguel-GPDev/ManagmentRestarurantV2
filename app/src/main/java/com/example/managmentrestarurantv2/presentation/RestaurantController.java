package com.example.managmentrestarurantv2.presentation;


import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.services.RestaurantServices;
import com.example.managmentrestarurantv2.business.services.impl.RestaurantFirebaseImpl;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseFirebaseImpl;

import java.util.List;

public class RestaurantController {
    RestaurantServices restaurantServices = new RestaurantFirebaseImpl();

    public Boolean create (Restaurant restaurant){
        return restaurantServices.create(restaurant);
    }
    public Restaurant read (String idRestaurant){
        restaurantServices.read(idRestaurant);
        return RestaurantRepositoryFirebaseFirebaseImpl.restaurant;
    }
    public Boolean update (String idRestaurante){
        return null;
    }
    public Boolean delete (String idRestaurante){
        return null;
    }
    public List<Restaurant> getAll (String idUsuario){
        return restaurantServices.getAll(idUsuario);
    }
}
