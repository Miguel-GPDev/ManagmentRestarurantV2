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
import com.example.res.R;
import com.example.managmentrestarurantv2.business.model.Bar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarFragment extends Fragment {
    Bar bar = new Bar();

    EditText editTextIdBar;
    EditText editTextNSeats;

    Switch aSwitchLocation;
    Switch aSwitchUnion;
    Switch aSwitchBooking;

    ImageView imageViewTrashBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarFragment newInstance(String param1, String param2) {
        BarFragment fragment = new BarFragment();
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
        View v = inflater.inflate(R.layout.view_bar, container, false);

        editTextIdBar = (EditText) v.findViewById(R.id.editTextIdBar);
        editTextNSeats = (EditText) v.findViewById(R.id.editTextNPersonBar);

        aSwitchBooking = (Switch) v.findViewById(R.id.switchBookingBar);
        aSwitchLocation = (Switch) v.findViewById(R.id.switchLocationBar);
        aSwitchUnion = (Switch) v.findViewById(R.id.switchUnionBar);

        imageViewTrashBar = (ImageView) v.findViewById(R.id.imageViewTrashBar);

        editTextIdBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bar.setIdBar(editTextIdBar.getText().toString());
            }
        });
        editTextNSeats.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bar.setSize(Integer.valueOf(editTextNSeats.getText().toString()));
            }
        });
        aSwitchUnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bar.setUnion(aSwitchUnion.isChecked());
            }
        });
        aSwitchLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bar.setLocation(aSwitchLocation.isChecked());
            }
        });
        aSwitchBooking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bar.setBooking(aSwitchBooking.isChecked());
            }
        });
        imageViewTrashBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllControls();
            }
        });
        return v;
    }

    private void clearAllControls() {
        editTextNSeats.setText("");
        editTextIdBar.setText("");

        aSwitchBooking.setChecked(true);
        aSwitchLocation.setChecked(true);
        aSwitchUnion.setChecked(true);

    }
}
