package com.example.managmentrestarurantv2.view.fragments;


import android.os.Build;
import android.os.Bundle;

import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Bar;
import com.example.managmentrestarurantv2.business.model.Booking;
import com.example.managmentrestarurantv2.business.model.Client;
import com.example.managmentrestarurantv2.business.model.Count;
import com.example.managmentrestarurantv2.business.model.Kitchen;
import com.example.managmentrestarurantv2.business.model.MenuRestaurant;
import com.example.managmentrestarurantv2.business.model.Product;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.model.SupplierRestaurant;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.view.adapters.Bar_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Kitchen_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Table_Adapter;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRestaurantCRUD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRestaurantCRUD extends Fragment {
    Restaurant restaurant = new Restaurant();

    Table_Adapter table_adapter;
    Bar_Adapter bar_adapter;
    Kitchen_Adapter kitchen_adapter;

    List<Restaurant> restaurantList;
    List<Table> tableList = new ArrayList<>();
    List<Kitchen> kitchenList = new ArrayList<>();
    List<Bar> barList = new ArrayList<>();
    List<Client> listClient = new ArrayList<>();
    List<MenuRestaurant> listMenus = new ArrayList<>();
    List<SupplierRestaurant> listSuppliers = new ArrayList<>();
    List<Booking> listBookings = new ArrayList<>();
    List<Product> listProducts = new ArrayList<>();
    List<Worker> listWorkers = new ArrayList<>();


    ImageView imageViewAddTable;
    ImageView imageViewDeleteTable;
    ImageView imageViewAddKitchen;
    ImageView imageViewDeleteKitchen;
    ImageView imageViewAddBar;
    ImageView imageViewDeleteBar;

    RecyclerView recyclerViewTable;
    RecyclerView recyclerViewBar;
    RecyclerView recyclerViewKitchen;
    RecyclerView recyclerViewWorker;

    Button buttoncreateRestaurant;
    Button buttonCancel;

    CardView cardViewTableExpand;
    CardView cardViewBarExpand;
    CardView cardViewKitchenExpand;
    CardView cardViewWorkerExpand;


    ConstraintLayout constraintLayoutTable;
    ConstraintLayout constraintLayoutKitchen;
    ConstraintLayout constraintLayoutBar;
    ConstraintLayout constraintLayoutWorker;

    EditText editTextIdRestaurante;

    TableFragmen tableFragmen;
    BarFragment barFragment;
    WorkerFragment workerFragment;

    Map<String, Count> countList = new HashMap<>();
    Map<String, Booking> bookinList = new HashMap<>();
    Map<String,Seat > seatList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRestaurantCRUD() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRestaurantCRUD.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRestaurantCRUD newInstance(String param1, String param2) {
        FragmentRestaurantCRUD fragment = new FragmentRestaurantCRUD();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_restaurant_c_r_u_d, container, false);

        editTextIdRestaurante = (EditText) v.findViewById(R.id.editTextIdRestaurantDashBoard);

        imageViewAddTable = (ImageView) v.findViewById(R.id.imageView17AddTable);
        imageViewAddBar = (ImageView) v.findViewById(R.id.imageView17AddBar);
        imageViewAddKitchen = (ImageView) v.findViewById(R.id.imageView17AddKitchen);

        imageViewDeleteTable  = (ImageView) v.findViewById(R.id.imageViewTrashTableDashBoard);
        imageViewDeleteBar = (ImageView) v.findViewById(R.id.imageViewTrashBarDashBoard);
        imageViewDeleteKitchen = (ImageView) v.findViewById(R.id.imageViewTrashKitchenDashBoard);

        cardViewTableExpand = (CardView) v.findViewById(R.id.cardViewTableExpand);
        cardViewBarExpand = (CardView) v.findViewById(R.id.cardViewBarExpand);
        cardViewKitchenExpand = (CardView) v.findViewById(R.id.cardViewKitchenExpand);
        cardViewWorkerExpand = (CardView) v.findViewById(R.id.cardViewWorkerExpand);

        buttoncreateRestaurant = (Button) v.findViewById(R.id.buttonCreatRestaurantDashBoard);
        buttonCancel = (Button) v.findViewById(R.id.button2CancelCreateRestaurantDashBoard);

        constraintLayoutTable = (ConstraintLayout) v.findViewById(R.id.constraintLayoutTable);
        constraintLayoutBar = (ConstraintLayout)v.findViewById(R.id.constraintLayoutBar);
        constraintLayoutKitchen = (ConstraintLayout) v.findViewById(R.id.constraintLayoutKitchen);
        constraintLayoutWorker = (ConstraintLayout) v.findViewById(R.id.constraintLayoutWorker);

        recyclerViewTable = (RecyclerView) v.findViewById(R.id.RVTable);
        recyclerViewBar = (RecyclerView) v.findViewById(R.id.RVBar);
        recyclerViewKitchen = (RecyclerView) v.findViewById(R.id.RVKitchen);
        recyclerViewWorker = (RecyclerView) v.findViewById(R.id.RVWorker);

        workerFragment();
        tableFragment();

        imageViewAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Table table = tableFragmen.getTable();

                if (editTextIdRestaurante.getText().toString() != null){
                    table.setIdRestaurant(
                            editTextIdRestaurante.getText().toString()
                    );
                }
                table.setListBooking(bookinList);
                table.setListCount(countList);

                if (table_adapter.getTableList() == null){
                    addTableList(table);
                    recyclerViewTable.setVisibility(View.VISIBLE);
                }else {
                    for (Table table1 : table_adapter.getTableList()){
                        if (table1.getIdMesa().equals(table.getIdMesa())){
                            //TODO Mensaje de Id repetido
                        }else{
                            addTableList(table);
                            recyclerViewTable.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        imageViewAddBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bar bar = barFragment.getBar();

                if (editTextIdRestaurante.getText().toString() != null){
                    bar.setIdRestaurant(
                            editTextIdRestaurante.getText().toString()
                    );
                }else{
                    //TODO MENSAJE DE QUE FALTA ID DEL RESTAURANTE
                }
                bar.setListBooking(bookinList);
                bar.setListCount(countList);
                bar.setSeatList(seatList);

                if (bar_adapter.getBarList() == null){
                    addBarList(bar);
                    recyclerViewBar.setVisibility(View.VISIBLE);
                }else {
                    for (Bar bar1 : bar_adapter.getBarList()){
                        if (bar1.getIdBar().equals(bar1.getIdBar())){
                            //TODO Mensaje de Id repetido
                        }else{
                            addBarList(bar);
                            recyclerViewBar.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
        imageViewAddKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cardViewTableExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayoutTable.getVisibility() == View.VISIBLE){
                    constraintLayoutTable.setVisibility(View.GONE);
                    recyclerViewTable.setVisibility(View.GONE);
                }else {
                    constraintLayoutTable.setVisibility(View.VISIBLE);
                }
            }
        });
        cardViewBarExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayoutBar.getVisibility() == View.VISIBLE){
                    constraintLayoutBar.setVisibility(View.GONE);
                    recyclerViewBar.setVisibility(View.GONE);
                }else {
                    constraintLayoutBar.setVisibility(View.VISIBLE);
                }
            }
        });
        cardViewKitchenExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayoutKitchen.getVisibility() == View.VISIBLE){
                    constraintLayoutKitchen.setVisibility(View.GONE);
                    recyclerViewKitchen.setVisibility(View.GONE);
                }else{
                    constraintLayoutKitchen.setVisibility(View.VISIBLE);
                }
            }
        });
        cardViewWorkerExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayoutWorker.getVisibility() == View.VISIBLE){
                    constraintLayoutWorker.setVisibility(View.GONE);
                    recyclerViewWorker.setVisibility(View.GONE);
                }else {
                    constraintLayoutWorker.setVisibility(View.VISIBLE);
                }
            }
        });

        buttoncreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

    private void addTableList(Table table) {
        tableList.add(table);
        uploadAdapterTable(tableList);
    }

    private void uploadAdapterTable(List<Table> tableList) {
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL
                ,false));
        table_adapter = new Table_Adapter(tableList);
        recyclerViewTable.setAdapter(table_adapter);
    }

    private void addKitchenList(Kitchen kitchen){
        kitchenList.add(kitchen);
        uploadAdapterKitchen(kitchenList);
    }

    private void uploadAdapterKitchen(List<Kitchen> kitchenList) {
        recyclerViewKitchen.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL
                ,false));
        kitchen_adapter = new Kitchen_Adapter(kitchenList);
        recyclerViewKitchen.setAdapter(kitchen_adapter);
    }

    private void addBarList(Bar bar){
        barList.add(bar);
        uploadAdapterBar(barList);
    }

    private void uploadAdapterBar(List<Bar> barList) {
        recyclerViewBar.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL
                ,false));
        bar_adapter = new Bar_Adapter(barList);
        recyclerViewBar.setAdapter(bar_adapter);
    }

    private Boolean checkNumber(String number){
        Boolean valid;
        try {
            Integer.parseInt(number);
            valid = true;
        }catch (Exception e){
            valid = false;
        }
        return  valid;
    }

    private Boolean noEmpty(String id){
        Boolean validId;
        if (id != null && id.trim().length() > 0){
            validId = true;
        }else {
            validId = false;
        }
        return  validId;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    private void workerFragment(){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        WorkerFragment workerFragment = new WorkerFragment();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutWorker,workerFragment);
        fragmentTransaction.commit();
    }

    private void tableFragment(){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        tableFragmen = new TableFragmen();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutTable,tableFragmen);
        fragmentTransaction.commit();

    }

    private void barFragment (){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        barFragment = new BarFragment();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutBar,barFragment);
        fragmentTransaction.commit();
    }
}
