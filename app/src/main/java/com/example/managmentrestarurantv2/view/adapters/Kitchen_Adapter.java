package com.example.managmentrestarurantv2.view.adapters;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.NonNull;
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
        Kitchen kitchen = new Kitchen();

        holder.editTextIdKitchen.setText(kitchen.getIdKitchen().toString());
        holder.editTextNworkers.setText(kitchen.getnWorkers().toString());

        holder.aSwitchOpenKitchen.setChecked(kitchen.getOpen());

        holder.imageViewTrashKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kitchenList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
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

        public kitchenHolder(@NonNull View itemView) {
            super(itemView);
            editTextNworkers = (EditText) itemView
                    .findViewById(R.id.editTextXWorkers);
            editTextIdKitchen = (EditText) itemView
                    .findViewById(R.id.editTextIdCocina);

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
}
