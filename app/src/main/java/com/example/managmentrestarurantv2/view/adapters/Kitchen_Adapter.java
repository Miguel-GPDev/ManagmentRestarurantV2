package com.example.managmentrestarurantv2.view.adapters;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Kitchen;

import java.util.List;

public class Kitchen_Adapter extends RecyclerView.Adapter<Kitchen_Adapter.kitchenHolder> {
    List<Kitchen> kitchenList ;

    public Kitchen_Adapter(List<Kitchen> kitchenList) {
        this.kitchenList = kitchenList;
    }

    @NonNull
    @Override
    public Kitchen_Adapter.kitchenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_kitchen
                        , parent
                        , false);
        kitchenHolder holder = new kitchenHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Kitchen_Adapter.kitchenHolder holder, @SuppressLint("RecyclerView") int position) {
        Kitchen kitchen = kitchenList.get(position);

        holder.editTextIdKitchen.setText(kitchen.getIdKitchen().toString());
        holder.editTextNworkers.setText(kitchen.getnWorkers().toString());

        holder.aSwitchOpenKitchen.setChecked(kitchen.getOpen());

        colorCardview(holder, kitchen);

        holder.imageViewTrashKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kitchenList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
            }
        });

        holder.editTextNworkers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                kitchenList.get(position).setnWorkers(holder.editTextNworkers.getText().toString());
                colorCardview(holder, kitchen);
            }
        });

        holder.editTextIdKitchen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                kitchenList.get(position).setIdKitchen(holder.editTextIdKitchen.getText().toString());
                colorCardview(holder, kitchen);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kitchenList.size();
    }

    public class kitchenHolder extends RecyclerView.ViewHolder {
        EditText editTextNworkers;
        EditText editTextIdKitchen;

        Switch aSwitchOpenKitchen;

        ImageView imageViewTrashKitchen;

        CardView cardViewKitchen;

        public kitchenHolder(@NonNull View itemView) {
            super(itemView);
            editTextNworkers = (EditText) itemView
                    .findViewById(R.id.editTextNWorkersKitchen);
            editTextIdKitchen = (EditText) itemView
                    .findViewById(R.id.editTextIdKitchen);

            aSwitchOpenKitchen =(Switch) itemView
                    .findViewById(R.id.switchOpenKitchen);

            imageViewTrashKitchen = (ImageView) itemView
                    .findViewById(R.id.imageViewTrashKitchen);
        }
    }

    public List<Kitchen> getKitchenList() {
        return kitchenList;
    }

    public void setKitchenList(List<Kitchen> kitchenList) {
        this.kitchenList = kitchenList;
    }

    private void colorCardview(Kitchen_Adapter.kitchenHolder holder, Kitchen kitchen) {
        if (verifyId(kitchen.getIdKitchen())){
            holder.cardViewKitchen.setCardBackgroundColor(Color.GREEN);
        }else{
            holder.cardViewKitchen.setCardBackgroundColor(Color.RED);
        }
    }

    public Boolean verifyId(String id){
        Boolean isValid;
        for (Kitchen kitchen : kitchenList){
            if (kitchen.getIdKitchen().equals(id)){
                isValid = false;
            }else{
                isValid = true;
            }
        }
        return  null;
    }
}
