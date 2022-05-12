package com.example.managmentrestarurantv2.business.services;

import com.example.managmentrestarurantv2.business.model.Restaurant;

import java.util.List;

public interface RestaurantServices {

    Boolean create (Restaurant restaurant);
    Restaurant read (String idResturant);
    Boolean update (String idRestaurante);
    Boolean delete (String idRestarurante);
    List<Restaurant> getAll(String idUsuario);
}
