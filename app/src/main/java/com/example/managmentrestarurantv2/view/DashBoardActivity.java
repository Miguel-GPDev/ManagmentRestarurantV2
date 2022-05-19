package com.example.managmentrestarurantv2.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.RestaurantRepository;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseImpl;

import com.example.managmentrestarurantv2.view.fragments.FragmentRestaurantCRUD;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {
    private Button buttonUpdateRestaurant;
    private Button buttonDeleteRestaurant;
    private Button buttonCloneResturant;
    private ImageView imageViewCreateRestaurant;

    private FirebaseAuth mAuth;

    private List<Restaurant> restaurantList = new ArrayList<>();
    private Spinner spinnerRestaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mAuth = FirebaseAuth.getInstance();

        buttonUpdateRestaurant = (Button) findViewById(R.id.button3Update);
        buttonDeleteRestaurant = (Button) findViewById(R.id.button4Delete);
        buttonCloneResturant = (Button) findViewById(R.id.button5Clone);

        imageViewCreateRestaurant = (ImageView) findViewById(R.id.imageViewAdd);

        spinnerRestaurantList = (Spinner) findViewById(R.id.spinnerListRestaurants);

        getRestaurants();

        imageViewCreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentRestaurantCRUD fragmentRestaurantCRUD = new FragmentRestaurantCRUD();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.ConstraintLayoutDashBoard,fragmentRestaurantCRUD);
                fragmentTransaction.commit();
            }
        });
    }

    private void getRestaurants() {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryFirebaseImpl();
        restaurantRepository.getAll(mAuth.getUid(), new CallBackFirebase() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                restaurantList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Restaurant restaurant = new Restaurant();
                    restaurant = dataSnapshot1.getValue(Restaurant.class);
                    restaurantList.add(restaurant);
                }
                loadSpinner(restaurantList);
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {
                //TODO
            }
        });
    }

    public void loadSpinner (List<Restaurant> list){
        ArrayAdapter<Restaurant> restaurantAdapter = new ArrayAdapter<>(DashBoardActivity.this, android.R.layout.simple_dropdown_item_1line, list);
        spinnerRestaurantList.setAdapter(restaurantAdapter);
        spinnerRestaurantList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Restaurant r = (Restaurant) parent.getItemAtPosition(position);
                //TODO
                //MOSTRAR LOS BOTONES PARA LAS POSIBLES ACCIONES
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO
                //MOSTRAR LOS BOTONES PARA LAS POSIBLES ACCIONES
            }
        });
    }
}