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
import android.widget.Toast;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Bar;
import com.example.managmentrestarurantv2.business.model.Booking;
import com.example.managmentrestarurantv2.business.model.Client;
import com.example.managmentrestarurantv2.business.model.Count;
import com.example.managmentrestarurantv2.business.model.Kitchen;
import com.example.managmentrestarurantv2.business.model.MenuRestaurant;
import com.example.managmentrestarurantv2.business.model.Product;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.model.Seat;
import com.example.managmentrestarurantv2.business.model.SupplierRestaurant;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.integration.RestaurantRepositoryFirebase;
import com.example.managmentrestarurantv2.integration.WorkerRepositoryFirebase;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseImpl;
import com.example.managmentrestarurantv2.integration.impl.WorkerRepositoryFirebaseImpl;
import com.example.managmentrestarurantv2.view.adapters.Bar_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Kitchen_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Table_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Worker_Adapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRestaurantCRUD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRestaurantCRUD extends Fragment {
    Restaurant restaurant = new Restaurant();


    List<Restaurant> restaurantList;
    List<Table> tableList = new ArrayList<>();
    List<Kitchen> kitchenList = new ArrayList<>();
    List<Bar> barList = new ArrayList<>();
    List<Client> listClient = new ArrayList<>();
    List<MenuRestaurant> listMenus = new ArrayList<>();
    List<SupplierRestaurant> listSuppliers = new ArrayList<>();
    List<Booking> listBookings = new ArrayList<>();
    List<Product> listProducts = new ArrayList<>();
    List<Worker> workerList = new ArrayList<>();


    Table_Adapter table_adapter ;
    Bar_Adapter bar_adapter ;
    Kitchen_Adapter kitchen_adapter;
    Worker_Adapter worker_adapter ;

    ImageView imageViewAddTable;
    ImageView imageViewDeleteTable;
    ImageView imageViewAddKitchen;
    ImageView imageViewDeleteKitchen;
    ImageView imageViewAddBar;
    ImageView imageViewDeleteBar;
    ImageView imageViewAddWorker;

    RecyclerView recyclerViewTable;
    RecyclerView recyclerViewBar;
    RecyclerView recyclerViewKitchen;
    RecyclerView recyclerViewWorker;

    Button buttonCreateRestaurant;
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
    KitchenFragment kitchenFragment;

    Map<String, Count> countList = new HashMap<>();
    Map<String, Booking> bookinList = new HashMap<>();
    Map<String, Seat> seatList = new HashMap<>();

    Boolean allOk;

    FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();

        editTextIdRestaurante = (EditText) v.findViewById(R.id.editTextIdRestaurantDashBoard);

        imageViewAddTable = (ImageView) v.findViewById(R.id.imageView17AddTable);
        imageViewAddBar = (ImageView) v.findViewById(R.id.imageView17AddBar);
        imageViewAddKitchen = (ImageView) v.findViewById(R.id.imageView17AddKitchen);
        imageViewAddWorker = (ImageView) v.findViewById(R.id.imageView17AddWorker);

        imageViewDeleteTable  = (ImageView) v.findViewById(R.id.imageViewTrashTableDashBoard);
        imageViewDeleteBar = (ImageView) v.findViewById(R.id.imageViewTrashBarDashBoard);
        imageViewDeleteKitchen = (ImageView) v.findViewById(R.id.imageViewTrashKitchenDashBoard);

        cardViewTableExpand = (CardView) v.findViewById(R.id.cardViewTableExpand);
        cardViewBarExpand = (CardView) v.findViewById(R.id.cardViewBarExpand);
        cardViewKitchenExpand = (CardView) v.findViewById(R.id.cardViewKitchenExpand);
        cardViewWorkerExpand = (CardView) v.findViewById(R.id.cardViewWorkerExpand);

        buttonCreateRestaurant = (Button) v.findViewById(R.id.buttonCreatRestaurantDashBoard);
        buttonCancel = (Button) v.findViewById(R.id.button2CancelCreateRestaurantDashBoard);

        constraintLayoutTable = (ConstraintLayout) v.findViewById(R.id.constraintLayoutTable);
        constraintLayoutBar = (ConstraintLayout)v.findViewById(R.id.constraintLayoutBar);
        constraintLayoutKitchen = (ConstraintLayout) v.findViewById(R.id.constraintLayoutKitchen);
        constraintLayoutWorker = (ConstraintLayout) v.findViewById(R.id.constraintLayoutWorker);

        recyclerViewTable = (RecyclerView) v.findViewById(R.id.RVTable);
        recyclerViewBar = (RecyclerView) v.findViewById(R.id.RVBar);
        recyclerViewKitchen = (RecyclerView) v.findViewById(R.id.RVKitchen);
        recyclerViewWorker = (RecyclerView) v.findViewById(R.id.RVWorker);

        tableFragment();
        kitchenFragment();
        barFragment();
        workerFragment();

        imageViewAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Table table = new Table();
                table = tableFragmen.getTable();

                if (editTextIdRestaurante.getText().toString() != null
                        &&
                        validIdResturant(editTextIdRestaurante.getText().toString())) {

                            table.setIdRestaurant(editTextIdRestaurante.getText().toString());
                            table.setListBooking(bookinList);
                            table.setListCount(countList);

                            if (isNumber(table.getIdMesa())
                                    &&
                                    isNumber(String.valueOf(table.getSize()))) {
                                addTableList(table);
                                recyclerViewTable.setVisibility(View.VISIBLE);

                                getParentFragmentManager().beginTransaction()
                                    .remove(getParentFragmentManager().findFragmentById(R.id.frameLayoutTable))
                                    .commit();
                                tableFragment();
                            }else{
                            //TODO MENSAJE DE QUE ALGO ESTA MAL
                        }
                }
            }
        });

        imageViewAddBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bar bar = barFragment.getBar();

                if (editTextIdRestaurante.getText().toString() != null &&
                        validIdResturant(editTextIdRestaurante.getText().toString())){

                    bar.setIdRestaurant(editTextIdRestaurante.getText().toString());

                    if (isNumber(bar.getIdBar()) && isNumber(String.valueOf(bar.getSize()))){
                        bar.setListBooking(bookinList);
                        bar.setListCount(countList);
                        bar.setSeatList(seatList);

                        addBarList(bar);
                        recyclerViewBar.setVisibility(View.VISIBLE);

                        getParentFragmentManager().beginTransaction()
                                .remove(getParentFragmentManager().findFragmentById(R.id.frameLayoutBar))
                                .commit();
                        barFragment();
                    }
                }else{
                    //TODO MENSAJE EL ID YA EXISTE
                }
            }
        });
        imageViewAddKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kitchen kitchen = kitchenFragment.getKitchen();

                if (editTextIdRestaurante.getText().toString() != null
                        && validIdResturant(editTextIdRestaurante.getText().toString())){

                    kitchen.setIdRestaurant(editTextIdRestaurante.getText().toString());
                    if (isNumber(kitchen.getIdKitchen()) && isNumber(String.valueOf(kitchen.getnWorkers()))){
                        addKitchenList(kitchen);
                        recyclerViewKitchen.setVisibility(View.VISIBLE);

                        getParentFragmentManager().beginTransaction()
                                .remove(getParentFragmentManager().findFragmentById(R.id.frameLayoutKitchen))
                                .commit();
                        kitchenFragment();
                    }
                }else{
                    //TODO MENSAJE DE QUE FALTA ID DEL RESTAURANTE
                }
            }
        });
        imageViewAddWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Worker worker = workerFragment.getWorker();
                worker.setIdBoss(mAuth.getUid());

                if (editTextIdRestaurante.getText().toString() != null
                        && validIdResturant(editTextIdRestaurante.getText().toString())){

                    worker.setIdRestaurant(editTextIdRestaurante.getText().toString());
                    if (noEmpty(worker.getNif()) && noEmpty(worker.getEmail())){
                        addWorkerList(worker);
                        recyclerViewWorker.setVisibility(View.VISIBLE);

                        getParentFragmentManager().beginTransaction()
                                .remove(getParentFragmentManager().findFragmentById(R.id.frameLayoutWorker))
                                .commit();
                        workerFragment();
                    }
                }else{
                    //TODO MENSAJE DE QUE FALTA ID DEL RESTAURANTE
                }
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
                    recyclerViewTable.setVisibility(View.VISIBLE);
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
                    recyclerViewBar.setVisibility(View.VISIBLE);
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
                    recyclerViewKitchen.setVisibility(View.VISIBLE);
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
                    recyclerViewWorker.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonCreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                /*
                Before to create the restauratn is necessary to verify the Id in alls List
                 */
                if (
                isOkTableList(table_adapter.getTableList())
                        &&
                isOkBarList(bar_adapter.getBarList())
                        &&
                isOkKitchenList(kitchen_adapter.getKitchenList())
                        &&
                isOkWorkerList(worker_adapter.getWorkerList())
                ){
                    /*/
                    -IF ALL IS TRUE , CONVERT LIST TO MAP
                    -ADD THE MAPS TO THE RESTAURANT
                    -CREATE IN THE DB
                    -CREATE THE USERS (WORKERS)
                     */
                    Map<String, Table> tableMap = tableList.stream()
                            .collect(Collectors.toMap(x->x.getIdMesa(), x -> x));
                    Map<String, Bar> barMap = barList.stream()
                            .collect(Collectors.toMap(x-> x.getIdBar(), x-> x));
                    Map<String, Kitchen> kitchenMap = kitchenList.stream()
                            .collect(Collectors.toMap(x-> x.getIdKitchen(), x-> x));
                    Map<String, Worker> workerMap = workerList.stream()
                            .collect(Collectors.toMap(x-> x.getNif(), x-> x));

                    restaurant.setIdRestaurant(editTextIdRestaurante.getText().toString());
                    restaurant.setName(editTextIdRestaurante.getText().toString());
                    restaurant.setEmail("falat añadir campo email");
                    restaurant.setLisBar(barMap);
                    restaurant.setListWorkers(workerMap);
                    restaurant.setListTables(tableMap);
                    restaurant.setListKitchen(kitchenMap);

                    RestaurantRepositoryFirebase restaurantRepositoryFirebase =
                            new RestaurantRepositoryFirebaseImpl();
                    restaurantRepositoryFirebase.create(restaurant);

                    for (Worker worker1 : workerList){
                        createWorkers(worker1);
                    }
                }
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

    private void createWorkers(Worker worker) {
        WorkerRepositoryFirebase workerRepositoryFirebase = new WorkerRepositoryFirebaseImpl();
        workerRepositoryFirebase.create(worker);

    }

    private Boolean isOkWorkerList(List<Worker> workerList) {
        boolean isOk = false;
        if (workerList.size() > 1){
            for (int i = 0 ; i < workerList.size() ; i++){
                for (int j = i + 1 ; j < workerList.size() ; j++){
                    if (workerList.get(i).getId().equals(workerList.get(j).getId())){
                        isOk = false;
                    }
                    else{
                        isOk = true;
                    }
                }
            }
        }else{
            isOk = true;
        }
        return isOk;
    }

    private Boolean isOkKitchenList(List<Kitchen> kitchenList) {
        boolean isOk = false;
        if (kitchenList.size() > 1){
            for (int i = 0 ; i < kitchenList.size() ; i++){
                for (int j = i + 1 ; j < kitchenList.size() ; j++){
                    if (kitchenList.get(i).getIdKitchen().equals(kitchenList.get(j).getIdKitchen())){
                        isOk = false;
                    }
                    else{
                        isOk = true;
                    }
                }
            }
        }else {
            isOk = true;
        }
        return isOk;
    }

    private Boolean isOkBarList(List<Bar> barList) {
        boolean isOk = false;
        if (barList.size() > 1){
            for (int i = 0 ; i < barList.size() ; i++){
                for (int j = i + 1 ; j < barList.size() ; j++){
                    if (barList.get(i).getIdBar().equals(barList.get(j).getIdBar())){
                        isOk = false;
                    }
                    else{
                        isOk = true;
                    }
                }
            }

        }else {
            isOk = true;
        }

        return isOk;
    }

    private Boolean isOkTableList(List<Table> tableList) {
        boolean isOk = false;
        if (tableList.size() > 1){
            for (int i = 0 ; i < tableList.size() ; i++){
                for (int j = i + 1 ; j < tableList.size() ; j++){
                    if (tableList.get(i).getIdMesa().equals(tableList.get(j).getIdMesa())){
                        isOk = false;
                    }
                    else{
                        isOk = true;
                    }
                }
            }
        }
        else{
            isOk = true;
        }
        return isOk;
    }

    private void addWorkerList(Worker worker) {
        workerList.add(worker);
        uploadAdapterWorker(workerList);
    }

    private void uploadAdapterWorker(List<Worker> workerList) {
        recyclerViewWorker.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL
                ,false));
        worker_adapter = new Worker_Adapter(workerList);
        recyclerViewWorker.setAdapter(worker_adapter);
    }

    private void addTableList(Table table) {
        tableList.add(table);
        uploadAdapterTable(tableList);

    }

    private void uploadAdapterTable(List<Table> tableList) {
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL
                ,true));
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

    private Boolean isNumber(String number){
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

    private void workerFragment(){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        workerFragment = new WorkerFragment();
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

    private void kitchenFragment (){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        kitchenFragment = new KitchenFragment();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutKitchen,kitchenFragment);
        fragmentTransaction.commit();
    }

    private boolean validIdResturant(String id){
        Boolean isOk = false;
        if(getRestaurantList().size() > 0){
            for (Restaurant restaurant1 : getRestaurantList()){
                if (id.equals(restaurant1.getName())){
                    Toast.makeText(getContext(), "El nombre del Restaurante ya existe, por favor cambialo", Toast.LENGTH_SHORT).show();
                    isOk = false;
                }
                else{
                    isOk = true;
                }
            }
        }else{
            isOk = true;
        }
        return isOk;
    }
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
