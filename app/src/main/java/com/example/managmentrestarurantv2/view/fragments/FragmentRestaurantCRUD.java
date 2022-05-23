package com.example.managmentrestarurantv2.view.fragments;


import android.os.Bundle;

import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import com.example.res.R;
import com.example.res.rest.business.model.*;
import com.example.res.rest.view.adapters.Bar_Adapter;
import com.example.res.rest.view.adapters.Kitchen_Adapter;
import com.example.res.rest.view.adapters.Table_Adapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


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

    List<Table> tableList = new ArrayList<>();
    List<Kitchen> kitchenList = new ArrayList<>();
    List<Bar> barList = new ArrayList<>();

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


        editTextIdTable = (EditText) v.findViewById(R.id.editTextIdTableDashBoard);
        editTextTableNPerson = (EditText) v.findViewById(R.id.editTextNpersonDashBoard);

        aSwitchTableBooking = (Switch) v.findViewById(R.id.switchBookingTableDashBoard);
        aSwitchTableLocation = (Switch) v.findViewById(R.id.switchLocationTableDashBoard);
        aSwitchTableUnion = (Switch) v.findViewById(R.id.switchUnionTableDashBoard);

        recyclerViewTable = (RecyclerView) v.findViewById(R.id.RVTable);

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
                    addToTableList(table);
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
        imageViewAddBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noEmpty(editTextIdBar.getText().toString()) && checkNumber(editTextNSeats.getText().toString())){
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

        buttoncreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restaurant.getIdRestaurant() != null){
                    updateRestaurant();
                } else {
                    newRestaurant();
                }
            }
        });
        return v;
    }

    private void updateRestaurant() {
    }

    private void newRestaurant() {
        final String  email = "johnDoe@gmail.com";
        final String  telf = "999999999999";
        final String cartaMenu= "Entrantes";
        final String suplier = " Carnes garcia";
        final String booking = String.valueOf(new Date().getTime());
        final String product = "carne";
        final String dni = "44881861Y";

        Map <String, Table> listTables = tableList.stream()
                .collect(Collectors.toMap(Table::getIdMesa, table -> table));
        Map <String, Kitchen> listKitchen = kitchenList.stream()
                .collect(Collectors.toMap(Kitchen::getIdKitchen, kitchen -> kitchen));
        Map <String, Bar> lisBar = barList.stream()
                .collect(Collectors.toMap(Bar::getIdBar,bar -> bar));

        Map <String, Client> listClient = new HashMap<>();
        Map <String, MenuRestaurant> listMenus = new HashMap<>();
        Map <String, SupplierRestaurant> listSuppliers = new HashMap<>();
        Map <String, Booking> listBookings = new HashMap<>();
        Map <String, Product> listProducts = new HashMap<>();
        Map <String, Worker> listWorkers = new HashMap<>();

        listClient.put(email,new Client(email,email,telf));
        listMenus.put(cartaMenu, new MenuRestaurant());
        listSuppliers.put(suplier, new SupplierRestaurant());
        listBookings.put(booking, new Booking());
        listProducts.put(product, new Product());
        listWorkers.put(dni, new Worker());
    }

    private void addToTableList(Table table) {
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
}
