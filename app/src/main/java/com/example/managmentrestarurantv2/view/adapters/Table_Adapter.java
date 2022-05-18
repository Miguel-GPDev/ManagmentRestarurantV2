package com.example.managmentrestarurantv2.view.adapters;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Table;


import java.util.List;

public class Table_Adapter extends RecyclerView.Adapter<Table_Adapter.tableViewHolder>{
    private List<Table> tableList;

    public Table_Adapter(List<Table> tableList) {
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public Table_Adapter.tableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_table
                        , parent
                        , false);
        tableViewHolder holder = new tableViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Table_Adapter.tableViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Table table = new Table();

        holder.editTextSize.setText(table.getSize());
        holder.editTextIdtable.setText(table.getIdMesa());

        holder.aSwitchBooking.setChecked(table.getBooking());
        holder.aSwitchLocation.setChecked(table.getLocation());
        holder.aSwitchUnion.setChecked(table.getUnion());

        holder.editTextIdtable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    tableList.get(position -1 ).setIdMesa(holder.editTextIdtable.getText().toString());
                    tableList.notifyAll();
                }catch (Exception e){

                }
            }
        });
        holder.editTextSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    tableList.get(position - 1).setSize(Integer.valueOf(holder.editTextSize.getText().toString()));
                    tableList.notifyAll();
                }catch (Exception e){

                }
            }
        });

        holder.aSwitchBooking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tableList.get(position -1 ).setBooking(holder.aSwitchBooking.isChecked());
                tableList.notifyAll();
            }
        });
        holder.aSwitchLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tableList.get(position -1).setLocation(holder.aSwitchLocation.isChecked());
                tableList.notifyAll();
            }
        });
        holder.aSwitchUnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tableList.get(position -1).setUnion(holder.aSwitchUnion.isChecked());
                tableList.notifyAll();
            }
        });

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tableList.remove(position -1);
                    notifyItemRemoved(position -1);
                    notifyItemRangeChanged(position -1, getItemCount());
                }catch (Exception e){
                    //TODO
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class tableViewHolder extends RecyclerView.ViewHolder {
        EditText editTextIdtable;
        EditText editTextSize;

        Switch aSwitchBooking;
        Switch aSwitchUnion;
        Switch aSwitchLocation;

        ImageView imageViewDelete;

        CardView cardViewTable;

        public tableViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO ENLAZAR LOS CONTROLES
        }
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

}
