package com.example.res.rest.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.res.R;
import com.example.res.rest.business.model.Booking;

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

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.menuHolder> {
    List<MenuRestaurant> menuRestaurantsList;

    @NonNull
    @Override
    public Menu_Adapter.menuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_menu, parent, false);
        Menu_Adapter.menuHolder holder = new menuHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Menu_Adapter.menuHolder holder, int position) {
        MenuRestaurant menuRestaurant = menuRestaurantsList.get(position);
    }

    @Override
    public int getItemCount() {
        return menuRestaurantsList.size();
    }

    public class menuHolder extends RecyclerView.ViewHolder{
        //TODO
        public menuHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}
