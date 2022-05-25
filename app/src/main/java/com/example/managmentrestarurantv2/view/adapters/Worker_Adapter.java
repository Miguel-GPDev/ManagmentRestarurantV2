package com.example.res.rest.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.res.R;
import com.example.res.rest.business.model.Worker;

import java.util.List;

public class Worker_Adapter extends RecyclerView.Adapter<Worker_Adapter.workerHolder>{
    List<Worker> workerList;

    public Worker_Adapter(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @NonNull
    @Override
    public Worker_Adapter.workerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_worker, parent, false);
        Worker_Adapter.workerHolder holder = new workerHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Worker_Adapter.workerHolder holder, int position) {
        Worker worker = workerList.get(position);

    }

    @Override
    public int getItemCount() {
        return workerList.size();
    }

    public class workerHolder extends RecyclerView.ViewHolder{
        //TODO CONTROLES
        public workerHolder(@NonNull View itemView) {
            super(itemView);
            //TODO ENLAZAR CONTROLES
        }
    }
}
