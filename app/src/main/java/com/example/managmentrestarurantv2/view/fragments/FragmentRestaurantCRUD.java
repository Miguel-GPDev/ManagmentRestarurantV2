package com.example.managmentrestarurantv2.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
import com.example.managmentrestarurantv2.business.model.Count;
import com.example.managmentrestarurantv2.business.model.Kitchen;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.view.adapters.Bar_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Kitchen_Adapter;
import com.example.managmentrestarurantv2.view.adapters.Table_Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restaurant_c_r_u_d, container, false);

        imageViewAddTable = (ImageView) v.findViewById(R.id.imageView17AddTable);
        imageViewDeleteTable  = (ImageView) v.findViewById(R.id.imageViewTrashTable);

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
                Table table = new Table(
                        editTextIdTable.getText().toString()
                        ,countList
                        ,bookinList
                        ,aSwitchTableUnion.isChecked()
                        ,Integer.parseInt(editTextTableNPerson.getText().toString())
                        ,"null"
                        ,aSwitchTableBooking.isChecked()
                        ,aSwitchTableLocation.isChecked()
                        ,"null"
                );
                recyclerViewTable.setVisibility(View.VISIBLE);
                addToTableList(table);
            }
        });
        
        return v;
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
    
}
