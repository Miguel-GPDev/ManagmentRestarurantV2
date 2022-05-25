package com.example.res.rest.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.res.R;
import com.example.res.rest.business.model.Product;

import java.util.List;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.productHolder> {
    List<Product> productsList;
    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product, parent, false);
        Product_Adapter.productHolder holder = new productHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull productHolder holder, int position) {
        Product product = productsList.get(position);
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class productHolder extends RecyclerView.ViewHolder {
        //TODO
        public productHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}
