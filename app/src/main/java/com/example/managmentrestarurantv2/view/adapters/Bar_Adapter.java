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
        Bar bar = barList.get(position);

        holder.editTextNSeatsBar.setText(String.valueOf(bar.getSize()));
        holder.editTextIdBar.setText(bar.getIdBar());

        holder.aSwitchBooking.setChecked(bar.getBooking());
        holder.aSwitchLocation.setChecked(bar.getLocation());
        holder.aSwitchUnion.setChecked(bar.getUnion());

        colorCardview(holder, bar);


        holder.editTextIdBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    barList.get(position ).setIdBar(holder.editTextIdBar.getText().toString());
                    colorCardview(holder, bar);
                }catch (Exception e){
                    //TODO
                }
            }
        });
        holder.editTextNSeatsBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    barList.get(position).setSize(Integer.valueOf(holder.editTextNSeatsBar.getText().toString()));
                    colorCardview(holder, bar);
                }catch (Exception e){
                    //TODO
                }
            }
        });

        holder.aSwitchBooking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position).setBooking(holder.aSwitchBooking.isChecked());
            }
        });
        holder.aSwitchLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position ).setLocation(holder.aSwitchLocation.isChecked());
            }
        });
        holder.aSwitchUnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                barList.get(position).setUnion(holder.aSwitchUnion.isChecked());
            }
        });

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    barList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, getItemCount());
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
        EditText editTextIdBar;
        EditText editTextNSeatsBar;

        Switch aSwitchBooking;
        Switch aSwitchUnion;
        Switch aSwitchLocation;

        ImageView imageViewDelete;

        CardView cardViewBar;
        public barHolder(@NonNull View itemView) {
            super(itemView);
            editTextIdBar = (EditText) itemView.findViewById(R.id.editTextIdBar);
            editTextNSeatsBar = (EditText) itemView.findViewById(R.id.editTextNPersonBar);

            aSwitchBooking =(Switch) itemView.findViewById(R.id.switchBookingBar);
            aSwitchLocation = (Switch) itemView.findViewById(R.id.switchLocationBar);
            aSwitchUnion = (Switch) itemView.findViewById(R.id.switchUnionBar);

            imageViewDelete = (ImageView) itemView.findViewById(R.id.imageViewTrashBar);

            cardViewBar = (CardView) itemView.findViewById(R.id.cardViewBarView);
        }
    }
    private void colorCardview(Bar_Adapter.barHolder holder, Bar bar) {
        if (verifyId(bar.getIdBar())){
            holder.cardViewBar.setCardBackgroundColor(Color.GREEN);
        }else{
            holder.cardViewBar.setCardBackgroundColor(Color.RED);
        }
    }

    public Boolean verifyId(String id){
        Boolean isValid;
        for (Bar bar : barList){
            if (bar.getIdBar().equals(id)){
                isValid = false;
            }else{
                isValid = true;
            }
        }
        return  null;
    }
}
