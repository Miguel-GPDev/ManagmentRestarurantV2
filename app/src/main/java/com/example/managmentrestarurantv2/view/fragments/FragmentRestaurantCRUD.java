package com.example.managmentrestarurantv2.view.fragments;


import android.os.Build;
import android.os.Bundle;

import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import com.example.managmentrestarurantv2.business.model.Seat;
import com.example.managmentrestarurantv2.business.model.SupplierRestaurant;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.integration.RestaurantRepository;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseImpl;
import com.example.managmentrestarurantv2.view.adapters.Bar_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Kitchen_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Table_Adapter;

import java.util.*;
import java.util.stream.Collectors;

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

    EditText editTextidResturante;
    EditText editTextIdTable;
    EditText editTextTableNPerson;
    EditText editTextIdBar;
    EditText editTextNSeats;
    EditText editTextIdKitchen;
    EditText editTextNWorkers;

    Switch aSwitchTableUnion;
    Switch aSwitchTableBooking;
    Switch aSwitchTableLocation;
    Switch aSwitchKitchenOpen;
    Switch aSwitchBarUnion;
    Switch aSwitchBarLocation;
    Switch aSwitchBarBooking;


    ImageView imageViewAddTable;
    ImageView imageViewDeleteTable;
    ImageView imageViewAddKitchen;
    ImageView imageViewDeleteKitchen;
    ImageView imageViewAddBar;
    ImageView imageViewDeleteBar;

    RecyclerView recyclerViewTable;
    RecyclerView recyclerViewBar;
    RecyclerView recyclerViewKitchen;

    Button buttoncreateRestaurant;
    Button buttonCancel;

    CardView cardViewTableExpand;
    CardView cardViewBarExpand;
    CardView cardViewKitchenExpand;
    CardView cardViewTableExpandDashBoard;
    CardView cardViewBarExpandDashBoard;
    CardView cardViewKitchenExpandDashBoard;

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

        imageViewAddTable = (ImageView) v.findViewById(R.id.imageView17AddTable);
        imageViewDeleteTable  = (ImageView) v.findViewById(R.id.imageViewTrashTableDashBoard);
        imageViewAddBar = (ImageView) v.findViewById(R.id.imageView17AddBarDashBoard);
        imageViewDeleteBar = (ImageView) v.findViewById(R.id.imageViewTrashBarDashBoard);
        imageViewAddKitchen = (ImageView) v.findViewById(R.id.imageView17AddKitchenDashBoard);
        imageViewDeleteKitchen = (ImageView) v.findViewById(R.id.imageViewTrashKitchenDashBoard);

        editTextIdTable = (EditText) v.findViewById(R.id.editTextIdTableDashBoard);
        editTextTableNPerson = (EditText) v.findViewById(R.id.editTextNpersonDashBoard);
        editTextIdBar = (EditText) v.findViewById(R.id.editTextIdBarDashBoard);
        editTextNSeats = (EditText) v.findViewById(R.id.editTextXPersonBarDashBoard);
        editTextIdKitchen = (EditText) v.findViewById(R.id.editTextIdKitchenDashBoard);
        editTextNWorkers = (EditText) v.findViewById(R.id.editTextXWorkersKitchenDashBoard);


        aSwitchTableBooking = (Switch) v.findViewById(R.id.switchBookingTableDashBoard);
        aSwitchTableLocation = (Switch) v.findViewById(R.id.switchLocationTableDashBoard);
        aSwitchTableUnion = (Switch) v.findViewById(R.id.switchUnionTableDashBoard);
        aSwitchBarBooking = (Switch)v.findViewById(R.id.switchBookingBarDashBoard);
        aSwitchBarLocation = (Switch) v.findViewById(R.id.switchLocationBarDashBoard);
        aSwitchBarUnion = (Switch) v.findViewById(R.id.switchUnionBarDashBoard);
        aSwitchKitchenOpen = (Switch) v.findViewById(R.id.switchOpenKitchenDashBoard);

        cardViewTableExpand = (CardView) v.findViewById(R.id.cardViewTableExpand);
        cardViewBarExpand = (CardView) v.findViewById(R.id.cardViewBarExpand);
        cardViewKitchenExpand = (CardView) v.findViewById(R.id.cardViewKitchenExpand);
        cardViewTableExpandDashBoard = (CardView) v.findViewById(R.id.cardViewTableDashBoard);
        cardViewBarExpandDashBoard = (CardView) v.findViewById(R.id.cardViewBarDashBoard);
        cardViewKitchenExpandDashBoard = (CardView) v.findViewById(R.id.cardViewKitchenDashBoard);

        buttoncreateRestaurant = (Button) v.findViewById(R.id.buttonCreatRestaurantDashBoard);
        buttonCancel = (Button) v.findViewById(R.id.button2CancelCreateRestaurantDashBoard);

        recyclerViewTable = (RecyclerView) v.findViewById(R.id.RVTable);
        recyclerViewBar = (RecyclerView) v.findViewById(R.id.RVBar);
        recyclerViewKitchen = (RecyclerView) v.findViewById(R.id.RVKitchen);


        imageViewAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Count> countList = new HashMap<>();
                Map<String, Booking> bookinList = new HashMap<>();


                if (noEmpty(editTextIdTable.getText().toString())
                        && checkNumber(editTextTableNPerson.getText().toString())){
                    Table table = new Table(
                            editTextIdTable.getText().toString().trim()
                            ,countList
                            ,bookinList
                            ,aSwitchTableUnion.isChecked()
                            ,Integer.parseInt(editTextTableNPerson.getText().toString().trim())
                            ,"null"
                            ,aSwitchTableBooking.isChecked()
                            ,aSwitchTableLocation.isChecked()
                            ,"null"
                    );
                    recyclerViewTable.setVisibility(View.VISIBLE);
                    addTableList(table);
                }
            }

        });
        imageViewAddBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = editTextIdBar.getText().toString();
                if (noEmpty(editTextIdBar.getText().toString())
                        && checkNumber(editTextNSeats.getText().toString())){
                    Map<String, Count> countList = new HashMap<>();
                    Map<String, Booking> bookinList = new HashMap<>();
                    Map<String, Seat> seatList = new HashMap<>();

                    Bar bar = new Bar(
                            editTextIdBar.getText().toString().trim()
                            ,countList
                            ,bookinList
                            ,aSwitchBarUnion.isChecked()
                            ,Integer.parseInt(editTextNSeats.getText().toString().trim())
                            ,seatList
                            ,"Null"
                            ,aSwitchBarBooking.isChecked()
                            ,aSwitchBarLocation.isChecked()
                            ,"null"
                    );
                    recyclerViewBar.setVisibility(View.VISIBLE);
                    addBarList(bar);
                }
            }
        });
        imageViewAddKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noEmpty(editTextIdKitchen.getText().toString()) && checkNumber(editTextNWorkers.getText().toString())){
                    Kitchen kitchen = new Kitchen(
                      editTextIdKitchen.getText().toString().trim()
                      ,editTextIdKitchen.getText().toString().trim()
                      ,editTextNWorkers.getText().toString()
                      ,editTextNWorkers.getText().toString()
                      ,aSwitchKitchenOpen.isChecked()
                      ,"null"
                      ,"null"
                      ,"null"
                    );
                    recyclerViewKitchen.setVisibility(View.VISIBLE);
                    addKitchenList(kitchen);
                }
            }
        });

        cardViewTableExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewTableExpandDashBoard.getVisibility() == View.VISIBLE){
                    cardViewTableExpandDashBoard.setVisibility(View.GONE);
                    recyclerViewTable.setVisibility(View.GONE);
                }else {
                    cardViewTableExpandDashBoard.setVisibility(View.VISIBLE);
                }
            }
        });
        cardViewBarExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewBarExpandDashBoard.getVisibility() == View.VISIBLE){
                    cardViewBarExpandDashBoard.setVisibility(View.GONE);
                    recyclerViewBar.setVisibility(View.GONE);
                }else {
                    cardViewBarExpandDashBoard.setVisibility(View.VISIBLE);
                }
            }
        });
        cardViewKitchenExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewKitchenExpandDashBoard.getVisibility() == View.VISIBLE){
                    cardViewKitchenExpandDashBoard.setVisibility(View.GONE);
                    recyclerViewKitchen.setVisibility(View.GONE);
                }else{
                    cardViewKitchenExpandDashBoard.setVisibility(View.VISIBLE);
                }
            }
        });

        buttoncreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (restaurant.getIdRestaurant() != null){
                    fillRestaurant();
                } else {
                    newRestaurant();
                }
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Verifica si es un nuevo restaurante o estas actualizando uno.
        if (restaurant.getIdRestaurant() != null){
            fillRestaurant();
        }
        fragmentworker();
        return v;
    }

    private void fillRestaurant() {
        uploadAdapterTable(tableList = new ArrayList<Table>(restaurant.getListTables().values()));
        uploadAdapterBar(barList = new ArrayList<Bar>(restaurant.getLisBar().values()));
        uploadAdapterKitchen(kitchenList = new ArrayList<Kitchen>(restaurant.getListKitchen().values()));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void newRestaurant() {
        final String  email = "johnDoe@gmail.com";
        final String  telf = "999999999999";
        final String cartaMenu= "Entrantes";
        final String suplier = " Carnes garcia";
        final String booking = String.valueOf(new Date().getTime());
        final String product = "carne";
        final String dni = "44881861Y";



        Map <String, Client> listClient = new HashMap<>();
        Map <String, MenuRestaurant> listMenus = new HashMap<>();
        Map <String, SupplierRestaurant> listSuppliers = new HashMap<>();
        Map <String, Booking> listBookings = new HashMap<>();
        Map <String, Product> listProducts = new HashMap<>();
        Map <String, Worker> listWorkers = new HashMap<>();

        listClient.put(email,new Client());
        listMenus.put(cartaMenu, new MenuRestaurant());
        listSuppliers.put(suplier, new SupplierRestaurant());
        listBookings.put(booking, new Booking());
        listProducts.put(product, new Product());
        listWorkers.put(dni, new Worker());

        updateRestaurant(listClient, listMenus, listSuppliers, listBookings, listProducts, listWorkers);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateRestaurant(Map<String, Client> listClient, Map<String
            , MenuRestaurant> listMenus, Map<String, SupplierRestaurant> listSuppliers
            , Map<String, Booking> listBookings, Map<String, Product> listProducts
            , Map<String, Worker> listWorkers) {

        Map <String, Table> listTables = tableList.stream()
                .collect(Collectors.toMap(Table::getIdMesa, table -> table));
        Map <String, Kitchen> listKitchen = kitchenList.stream()
                .collect(Collectors.toMap(Kitchen::getIdKitchen, kitchen -> kitchen));
        Map <String, Bar> listBar = barList.stream()
                .collect(Collectors.toMap(Bar::getIdBar,bar -> bar));

        if (isValidIdRestaurant(editTextIdTable.getText().toString())){
            restaurant.setIdRestaurant(editTextidResturante.getText().toString());
            restaurant.setEmail("null");
            restaurant.setLisBar(listBar);
            restaurant.setListTables(listTables);
            restaurant.setListKitchen(listKitchen);
            restaurant.setListClient(listClient);
            restaurant.setListMenus(listMenus);
            restaurant.setListSuppliers(listSuppliers);
            restaurant.setListBookings(listBookings);
            restaurant.setListProducts(listProducts);
            restaurant.setListWorkers(listWorkers);

            createRestaurant(restaurant);
        }else {
            // TODO MENSAJE CAMBIO DE NOMBRE DEL RESTAURANTE
        }
    }

    private void listToMap (){

    }

    private void createRestaurant(Restaurant restaurant) {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryFirebaseImpl();
        restaurantRepository.create(restaurant);
    }

    private Boolean isValidIdRestaurant(String toString) {
        Boolean valid = true;

        for (Restaurant lista : restaurantList){
            if (lista.getIdRestaurant().toString().equals(editTextidResturante.getText().toString())){
                valid = true;
            }
        }
        return  valid;
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

    private void fragmentworker(){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        BlankFragment blankFragment = new BlankFragment();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutWorker,blankFragment);
        fragmentTransaction.commit();
    }
}
