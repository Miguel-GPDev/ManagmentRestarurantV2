package com.example.managmentrestarurantv2.view;

import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.presentation.RestaurantController;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    List<Restaurant> restaurantList = new ArrayList<>();
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mAuth = FirebaseAuth.getInstance();

        RestaurantController restaurantController = new RestaurantController();
        restaurantList = restaurantController.getAll(mAuth.getUid());

    }
}