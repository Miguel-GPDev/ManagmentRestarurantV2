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
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Bar;

import java.util.List;

public class Bar_Adapter extends RecyclerView.Adapter<Bar_Adapter.barHolder> {
    List<Bar> barList;

    public Bar_Adapter(List<Bar> barList) {
        this.barList = barList;
    }

    @NonNull
    @Override
    public Bar_Adapter.barHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_bar
                        , parent
                        , false);
        Bar_Adapter.barHolder holder = new barHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull barHolder holder, @SuppressLint("RecyclerView") int position) {
        Bar bar = new Bar();

        holder.editTextSize.setText(bar.getSize());
        holder.editTextidBar.setText(bar.getIdBar());

        holder.aSwitchBooking.setChecked(bar.getBooking());
        holder.aSwitchLocation.setChecked(bar.getLocation());
        holder.aSwitchUnion.setChecked(bar.getUnion());

        holder.editTextidBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    barList.get(position -1 ).setIdBar(holder.editTextidBar.getText().toString());
                    barList.notifyAll();
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
                    barList.get(position - 1).setSize(Integer.valueOf(holder.editTextSize.getText().toString()));
                    barList.notifyAll();
                }catch (Exception e){

                }
            }
        });

        holder.aSwitchBooking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position -1 ).setBooking(holder.aSwitchBooking.isChecked());
                barList.notifyAll();
            }
        });
        holder.aSwitchLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position -1).setLocation(holder.aSwitchLocation.isChecked());
                barList.notifyAll();
            }
        });
        holder.aSwitchUnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position -1).setUnion(holder.aSwitchUnion.isChecked());
                barList.notifyAll();
            }
        });

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    barList.remove(position -1);
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
        return barList.size();
    }

    public class barHolder extends RecyclerView.ViewHolder {
        EditText editTextidBar;
        EditText editTextSize;

        Switch aSwitchBooking;
        Switch aSwitchUnion;
        Switch aSwitchLocation;

        ImageView imageViewDelete;

        CardView cardViewTable;
        public barHolder(@NonNull View itemView) {
            super(itemView);
            //TODO ENLAZAR CONTROLES
        }
    }
}
