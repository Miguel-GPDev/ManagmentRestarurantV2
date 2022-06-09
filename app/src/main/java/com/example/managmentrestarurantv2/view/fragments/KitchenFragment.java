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

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Kitchen;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KitchenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KitchenFragment extends Fragment {
    Kitchen kitchen = new Kitchen();

    EditText editTextIdKitchen;
    EditText editTextNWorkersKitchen;

    Switch aSwitchOpenKitchen;

    ImageView imageViewCleankitchen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KitchenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KitchenFragment newInstance(String param1, String param2) {
        KitchenFragment fragment = new KitchenFragment();
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
        View v = inflater.inflate(R.layout.view_kitchen, container, false);

        imageViewCleankitchen = (ImageView) v.findViewById(R.id.imageViewTrashKitchen);

        editTextIdKitchen = (EditText) v.findViewById(R.id.editTextIdKitchen);
        editTextNWorkersKitchen = (EditText) v.findViewById(R.id.editTextNWorkersKitchen);

        aSwitchOpenKitchen = (Switch) v.findViewById(R.id.switchOpenKitchen);
        kitchen.setOpen(aSwitchOpenKitchen.isChecked());

        editTextIdKitchen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                kitchen.setIdKitchen(editTextIdKitchen.getText().toString());
            }
        });
        editTextNWorkersKitchen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                kitchen.setnWorkers(editTextNWorkersKitchen.getText().toString());
            }
        });
        aSwitchOpenKitchen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                kitchen.setOpen(aSwitchOpenKitchen.isChecked());
            }
        });
        imageViewCleankitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAllControls();
            }
        });
        return v;
    }

    private void cleanAllControls() {
        editTextIdKitchen.setText("");
        editTextNWorkersKitchen.setText("");
        aSwitchOpenKitchen.setChecked(true);
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
