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

public class Supplier_Adapter extends RecyclerView.Adapter<Supplier_Adapter.supplierHolder> {
    List<SupplierRestaurant> supplierRestaurantList;
    @NonNull
    @Override
    public Supplier_Adapter.supplierHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_supplier, parent, false);
        Supplier_Adapter.supplierHolder holder = new supplierHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Supplier_Adapter.supplierHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return supplierRestaurantList.size();
    }

    public class supplierHolder extends RecyclerView.ViewHolder{
        //TODO
        public supplierHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}
