package com.example.managmentrestarurantv2.view.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.business.model.Worker;


import java.util.ArrayList;
import java.util.List;

public class Worker_Adapter extends RecyclerView.Adapter<Worker_Adapter.workerHolder>{
    List<Worker> workerList;
    List<Worker_Adapter.workerHolder> workerHoldersList = new ArrayList<>();

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
        holder.editTextAdressWorker.setText(worker.getAddress());
        holder.editTextContracWorker.setText(worker.getContract());
        holder.editTextEmailworker.setText(worker.getEmail());
        holder.editTextDataworker.setText(worker.getDateContract());
        holder.editTextNameWorker.setText(worker.getName());
        holder.editTextSurnameWorker.setText(worker.getSurname1());
        holder.editTextSurname2Worker.setText(worker.getSurname2());
        holder.editTextNifWorker.setText(worker.getNif());
        holder.editTextPhoneWorker.setText(worker.getTelefono());

        holder.cardViewWorker.setCardBackgroundColor(Color.GREEN);
        holder.cardViewWorker.setRotationX(10);

    }

    @Override
    public int getItemCount() {
        return workerList.size();
    }

    private void asignColor(int position) {
        if (getItemCount() -1  == position ){
            for (int i = 0 ; i < workerList.size() ; i++){
                for (int j =  i + 1  ; j < workerList.size() ; j++) {
                    if (workerList.get(i).getId().equals(workerList.get(j).getId())){
                        workerHoldersList.get(i)
                                .cardViewWorker.setCardBackgroundColor(Color.RED);
                        workerHoldersList.get(j)
                                .cardViewWorker.setCardBackgroundColor(Color.RED);
                    }
                }
            }
        }
    }
    private void allGreen(){
        if (workerHoldersList != null){
            for (Worker_Adapter.workerHolder h : workerHoldersList){
                h.cardViewWorker.setCardBackgroundColor(Color.GREEN);
            }
        }
    }

    public class workerHolder extends RecyclerView.ViewHolder{
        Spinner spinnerChargeWorker;
        Spinner spinnerRestauratnWorker;
        Spinner spinnerStatusWorker;
        Spinner spinnerWorkPlace;

        EditText editTextContracWorker ;
        EditText editTextDataworker ;
        EditText editTextEmailworker ;
        EditText editTextNifWorker ;
        EditText editTextNameWorker ;
        EditText editTextSurnameWorker;
        EditText editTextSurname2Worker ;
        EditText editTextPhoneWorker ;
        EditText editTextAdressWorker ;

        CardView cardViewWorker;

        public workerHolder(@NonNull View itemView) {
            super(itemView);
            spinnerChargeWorker = (Spinner) itemView.findViewById(R.id.spinner4ChargeWorker);
            spinnerRestauratnWorker = (Spinner) itemView.findViewById(R.id.spinner2RestaurantWorker);
            spinnerStatusWorker = (Spinner) itemView.findViewById(R.id.spinnerStatusWorker);
            spinnerWorkPlace = (Spinner) itemView.findViewById(R.id.spinner5workPlaceWorker);

            editTextContracWorker = (EditText) itemView.findViewById(R.id.editTextContracWorker);
            editTextDataworker = (EditText) itemView.findViewById(R.id.editTextDateWorker);
            editTextEmailworker = (EditText) itemView.findViewById(R.id.editTextEmailWorker);
            editTextNifWorker = (EditText) itemView.findViewById(R.id.editTextNifWorker);
            editTextNameWorker = (EditText) itemView.findViewById(R.id.editTextNameWorker);
            editTextSurnameWorker = (EditText)itemView.findViewById(R.id.editTextSurnameWorker);
            editTextSurname2Worker = (EditText) itemView.findViewById(R.id.editTextSurname2Worker);
            editTextPhoneWorker = (EditText) itemView.findViewById(R.id.editTextPhoneWorker);
            editTextAdressWorker = (EditText) itemView.findViewById(R.id.editTextTextAdressWorker);

            cardViewWorker =(CardView) itemView.findViewById(R.id.cardViewWorkerView);
        }
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
