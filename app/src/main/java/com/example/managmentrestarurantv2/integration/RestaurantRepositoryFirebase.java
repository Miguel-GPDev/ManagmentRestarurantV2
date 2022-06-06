package com.example.managmentrestarurantv2.integration;

import com.example.managmentrestarurantv2.business.model.Restaurant;

public interface RestaurantRepositoryFirebase {
    Boolean create (Restaurant restaurant);
    void read (String idResturant, CallBackFirebase callBackFirebase);
    Boolean update (String idRestaurante);
    Boolean delete (String idRestarurante);
    void getAll (String idUsuario, CallBackFirebase callBackFirebase);
    void getListName (String idUsuario, CallBackFirebase callBackFirebase);
}
