package com.example.managmentrestarurantv2.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Worker;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkerFragment extends Fragment {
    Worker worker = new Worker();

    private FirebaseAuth mAuth;

    Spinner spinnerChargeWorker;
    Spinner spinnerWorkPlace;
    Spinner spinnerRestauratnWorker;
    Spinner spinnerStatusWorker;

    EditText editTextDataworker;
    EditText editTextContracWorker;
    EditText editTextPhoneWorker;
    EditText editTextEmailworker;
    EditText editTextNameWorker;
    EditText editTextSurnameWorker;
    EditText editTextSurname2Worker;
    EditText editTextNifWorker;
    EditText editTextAdressWorker;

    ImageView imageViewCalendarWorker;
    ImageView imageViewTelephoneWorker;
    ImageView imageViewInfoWorker;
    ImageView imageViewTrashWorker;
    ImageView imageViewDatesWorker;
    ImageView imageViewEmailWorker;
    ImageView imageViewPhotoWorker;

    TextView textViewNameCompleteWorker;

    ConstraintLayout constraintLayoutInfoWorker;
    ConstraintLayout constraintLayoutCalendar;
    ConstraintLayout constraintLayoutTelephone;
    ConstraintLayout constraintLayoutDates;
    ConstraintLayout constraintLayoutEmail;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorkerFragment() {
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
    public static WorkerFragment newInstance(String param1, String param2) {
        WorkerFragment fragment = new WorkerFragment();
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
        View v =  inflater.inflate(R.layout.view_worker, container, false);
        mAuth = FirebaseAuth.getInstance();
        worker.setIdBoss(mAuth.getUid());

        spinnerChargeWorker = (Spinner) v.findViewById(R.id.spinner4ChargeWorker);
        spinnerRestauratnWorker = (Spinner) v.findViewById(R.id.spinner2RestaurantWorker);
        spinnerStatusWorker = (Spinner) v.findViewById(R.id.spinnerStatusWorker);
        spinnerWorkPlace = (Spinner) v.findViewById(R.id.spinner5workPlaceWorker);

        editTextContracWorker = (EditText) v.findViewById(R.id.editTextContracWorker);
        editTextDataworker = (EditText) v.findViewById(R.id.editTextDateWorker);
        editTextEmailworker = (EditText) v.findViewById(R.id.editTextEmailWorker);
        editTextNifWorker = (EditText) v.findViewById(R.id.editTextNifWorker);
        editTextNameWorker = (EditText) v.findViewById(R.id.editTextNameWorker);
        editTextSurnameWorker = (EditText) v.findViewById(R.id.editTextSurnameWorker);
        editTextSurname2Worker = (EditText) v.findViewById(R.id.editTextSurname2Worker);
        editTextPhoneWorker = (EditText) v.findViewById(R.id.editTextPhoneWorker);
        editTextAdressWorker = (EditText)v.findViewById(R.id.editTextTextAdressWorker);

        imageViewCalendarWorker = (ImageView) v.findViewById(R.id.imageView22CalendarWorker);
        imageViewDatesWorker = (ImageView) v.findViewById(R.id.imageView19DatesWorker);
        imageViewEmailWorker = (ImageView) v.findViewById(R.id.imageView18EmailWorker);
        imageViewInfoWorker = (ImageView) v.findViewById(R.id.imageView23InfoWorker);
        imageViewTelephoneWorker = (ImageView) v.findViewById(R.id.imageView21TelephoneWorker);
        imageViewTrashWorker = (ImageView) v.findViewById(R.id.imageView20TrashWorker);
        imageViewPhotoWorker = (ImageView) v.findViewById(R.id.imageView17PhotoWorker);

        constraintLayoutCalendar = (ConstraintLayout) v.findViewById(R.id.ConstraintLayoutCalendar);
        constraintLayoutDates = (ConstraintLayout) v.findViewById(R.id.ConstraintLayoutDates);
        constraintLayoutInfoWorker = (ConstraintLayout) v.findViewById(R.id.ConstraintLayoutInfoWorker);
        constraintLayoutTelephone = (ConstraintLayout) v.findViewById(R.id.ConstraintLayoutTelephone);
        constraintLayoutEmail = (ConstraintLayout) v.findViewById(R.id.ConstraintLayoutEmail);

        imageViewCalendarWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll();
                constraintLayoutCalendar.setVisibility(View.VISIBLE);
            }
        });
        imageViewDatesWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll();
                constraintLayoutDates.setVisibility(View.VISIBLE);
            }
        });
        imageViewInfoWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll();
                constraintLayoutInfoWorker.setVisibility(View.VISIBLE);
            }
        });
        imageViewTelephoneWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll();
                constraintLayoutTelephone.setVisibility(View.VISIBLE);
            }
        });
        imageViewEmailWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll();
                constraintLayoutEmail.setVisibility(View.VISIBLE);
            }
        });

        editTextPhoneWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setTelefono(editTextPhoneWorker.getText().toString());
            }
        });
        editTextEmailworker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setEmail(editTextEmailworker.getText().toString());

            }
        });
        editTextNameWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setName(editTextNameWorker.getText().toString());
            }
        });
        editTextSurnameWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setSurname1(editTextSurnameWorker.getText().toString());
            }
        });
        editTextSurname2Worker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setSurname2(editTextSurname2Worker.getText().toString());
            }
        });
        editTextNifWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setNif(editTextNifWorker.getText().toString());
            }
        });
        editTextDataworker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setVariable2(editTextDataworker.getText().toString());
            }
        });
        editTextContracWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setContract(Integer.parseInt(editTextContracWorker.getText().toString()));
            }
        });
        editTextAdressWorker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                worker.setAddress(editTextAdressWorker.getText().toString());
            }
        });

        spinnerWorkPlace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                worker.setWorkPlace(spinnerWorkPlace.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerStatusWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerRestauratnWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                worker.setIdRestaurant(spinnerRestauratnWorker.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerChargeWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                worker.setCharge(spinnerChargeWorker.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }
    private void closeVisibilityAll(){
        constraintLayoutInfoWorker.setVisibility(View.GONE);
        constraintLayoutCalendar.setVisibility(View.GONE);
        constraintLayoutTelephone.setVisibility(View.GONE);
        constraintLayoutDates.setVisibility(View.GONE);
        constraintLayoutEmail.setVisibility(View.GONE);
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
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
