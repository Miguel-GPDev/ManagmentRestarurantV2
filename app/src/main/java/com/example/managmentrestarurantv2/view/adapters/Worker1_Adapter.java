package com.example.managmentrestarurantv2.view.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managmentrestarurantv2.view.fragments.WorkerFragment;

import java.util.List;

public class Worker1_Adapter extends RecyclerView.Adapter<Worker1_Adapter.workerHolder> {
    List<WorkerFragment> workerFragmentList;

    public Worker1_Adapter(List<WorkerFragment> workerFragmentList) {
        this.workerFragmentList = workerFragmentList;
    }

    @NonNull
    @Override
    public Worker1_Adapter.workerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Worker1_Adapter.workerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class workerHolder extends RecyclerView.ViewHolder {

        public workerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
