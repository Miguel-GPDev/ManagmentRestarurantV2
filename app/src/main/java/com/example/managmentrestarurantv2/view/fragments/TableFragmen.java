package com.example.managmentrestarurantv2.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.res.rest.business.model.Table;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableFragmen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragmen extends Fragment {
    Table table = new Table();

    EditText editTextIdTable;
    EditText editTextTableNPerson;

    Switch aSwitchTableUnion;
    Switch aSwitchTableBooking;
    Switch aSwitchTableLocation;

    ImageView imageViewCleanTable;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableFragmen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragmen.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragmen newInstance(String param1, String param2) {
        TableFragmen fragment = new TableFragmen();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_table, container, false);

        editTextIdTable = (EditText) v.findViewById(R.id.editTextIdTable);
        editTextTableNPerson = (EditText) v.findViewById(R.id.editTextXPersonTable);

        aSwitchTableBooking = (Switch) v.findViewById(R.id.switchBookingTable);
        aSwitchTableLocation = (Switch) v.findViewById(R.id.switchLocationTable);
        aSwitchTableUnion = (Switch) v.findViewById(R.id.switchUnionTable);

        imageViewCleanTable = (ImageView) v.findViewById(R.id.imageViewTrashTable);

        editTextIdTable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                table.setIdMesa(editTextIdTable.getText().toString());
            }
        });

        editTextTableNPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                table.setSize(Integer.valueOf(editTextTableNPerson.getText().toString()));
            }
        });

        aSwitchTableBooking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                table.setBooking(aSwitchTableBooking.isChecked());
            }
        });
        aSwitchTableLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                table.setLocation(aSwitchTableLocation.isChecked());
            }
        });
        aSwitchTableUnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                table.setUnion(aSwitchTableUnion.isChecked());
            }
        });

        imageViewCleanTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAllControls();
            }
        });
        return v;
    }

    private void cleanAllControls(){
        editTextIdTable.setText("");
        editTextTableNPerson.setText("");

        aSwitchTableUnion.setChecked(true);
        aSwitchTableLocation.setChecked(true);
        aSwitchTableBooking.setChecked(true);
    }
}
