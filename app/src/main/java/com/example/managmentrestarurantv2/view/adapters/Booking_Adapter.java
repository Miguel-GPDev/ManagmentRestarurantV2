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
import com.example.managmentrestarurantv2.business.model.Table;


import java.util.List;

public class Booking_Adapter extends RecyclerView.Adapter<Booking_Adapter.bookingHolder> {
    List<Booking> bookingList;
    @NonNull
    @Override
    public Booking_Adapter.bookingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_booking, parent, false);
        Booking_Adapter.bookingHolder holder = new bookingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Booking_Adapter.bookingHolder holder, int position) {
        Booking booking = bookingList.get(position);
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class bookingHolder extends RecyclerView.ViewHolder{
        //TODO
        public bookingHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}

public class Booking_Adapter extends RecyclerView.Adapter<Booking_Adapter.bookingHolder> {
    List<Booking> bookingList;
    @NonNull
    @Override
    public Booking_Adapter.bookingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_booking, parent, false);
        Booking_Adapter.bookingHolder holder = new bookingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Booking_Adapter.bookingHolder holder, int position) {
        Booking booking = bookingList.get(position);
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class bookingHolder extends RecyclerView.ViewHolder{
        //TODO
        public bookingHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}
