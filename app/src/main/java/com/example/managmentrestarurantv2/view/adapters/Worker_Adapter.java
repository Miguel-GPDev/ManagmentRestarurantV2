package com.example.managmentrestarurantv2.view.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managmentrestarurantv2.R;
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
        holder.editTextContracWorker.setText(String.valueOf(worker.getContract()));
        holder.editTextEmailworker.setText(worker.getEmail());
        holder.editTextDataworker.setText(worker.getDateContract());
        holder.editTextNameWorker.setText(worker.getName());
        holder.editTextSurnameWorker.setText(worker.getSurname1());
        holder.editTextSurname2Worker.setText(worker.getSurname2());
        holder.editTextNifWorker.setText(worker.getNif());
        holder.editTextPhoneWorker.setText(worker.getTelefono());

        holder.cardViewWorker.setCardBackgroundColor(Color.GREEN);
        holder.cardViewWorker.setRotationX(2);

        loadSpinnerChargeWorker(holder, worker);
        loadSpinnerStatusWorker(holder, worker);
        loadSpinnerWorksPlace(holder, worker);
        closeVisibilityAll(holder);

        holder.spinnerStatusWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                workerList.get(position).setState(holder.spinnerStatusWorker.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        holder.spinnerRestauratnWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                workerList.get(position).setName(holder.spinnerRestauratnWorker.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        holder.spinnerChargeWorker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                workerList.get(position).setCharge(holder.spinnerChargeWorker.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        holder.imageViewCalendarWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll(holder);
                holder.constraintLayoutCalendar.setVisibility(View.VISIBLE);
            }
        });
        holder.imageViewDatesWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll(holder);
                holder.constraintLayoutDates.setVisibility(View.VISIBLE);
            }
        });
        holder.imageViewInfoWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll(holder);
                holder.constraintLayoutInfoWorker.setVisibility(View.VISIBLE);
            }
        });
        holder.imageViewTelephoneWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll(holder);
                holder.constraintLayoutTelephone.setVisibility(View.VISIBLE);
            }
        });
        holder.imageViewEmailWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeVisibilityAll(holder);
                holder.constraintLayoutEmail.setVisibility(View.VISIBLE);
            }
        });
    }

    private void closeVisibilityAll(@NonNull workerHolder holder){
        holder.constraintLayoutInfoWorker.setVisibility(View.GONE);
        holder.constraintLayoutCalendar.setVisibility(View.GONE);
        holder.constraintLayoutTelephone.setVisibility(View.GONE);
        holder.constraintLayoutDates.setVisibility(View.GONE);
        holder.constraintLayoutEmail.setVisibility(View.GONE);
    }

    private void loadSpinnerChargeWorker(@NonNull workerHolder holder, Worker worker) {
        Resources resources = holder.context.getResources();
        String [] arrayChargeWorker = resources.getStringArray(R.array.Cargos);
        ArrayAdapter<String> chargeWorkerAdapter = new ArrayAdapter<String>(holder.context, android.R.layout.simple_dropdown_item_1line, arrayChargeWorker);
        holder.spinnerChargeWorker.setAdapter(chargeWorkerAdapter);
        worker.setCharge(holder.spinnerChargeWorker.getSelectedItem().toString());
    }

    private void loadSpinnerStatusWorker(@NonNull workerHolder holder, Worker worker) {
        Resources resources = holder.context.getResources();
        String [] arrayStatusWorker = resources.getStringArray(R.array.Estado);
        ArrayAdapter<String> statusWorkerAdapter = new ArrayAdapter<String>(holder.context, android.R.layout.simple_dropdown_item_1line, arrayStatusWorker);
        holder.spinnerStatusWorker.setAdapter(statusWorkerAdapter);
        worker.setState(holder.spinnerStatusWorker.getSelectedItem().toString());
    }

    private void loadSpinnerWorksPlace(@NonNull workerHolder holder, Worker worker) {
        Resources resources = holder.context.getResources();
        String [] arrayWorksPlaces = resources.getStringArray(R.array.Puestos);
        ArrayAdapter<String> workerPlaceAdapter = new ArrayAdapter<String>(holder.context, android.R.layout.simple_dropdown_item_1line, arrayWorksPlaces);
        holder.spinnerWorkPlace.setAdapter(workerPlaceAdapter);
        worker.setWorkPlace(holder.spinnerWorkPlace.getSelectedItem().toString());
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

        ImageView imageViewCalendarWorker;
        ImageView imageViewTelephoneWorker;
        ImageView imageViewInfoWorker;
        ImageView imageViewTrashWorker;
        ImageView imageViewDatesWorker;
        ImageView imageViewEmailWorker;
        ImageView imageViewPhotoWorker;

        ConstraintLayout constraintLayoutInfoWorker;
        ConstraintLayout constraintLayoutCalendar;
        ConstraintLayout constraintLayoutTelephone;
        ConstraintLayout constraintLayoutDates;
        ConstraintLayout constraintLayoutEmail;

        Context context;

        public workerHolder(@NonNull View itemView) {
            super(itemView);
            context = (Context)itemView.getContext();

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

            imageViewCalendarWorker = (ImageView) itemView.findViewById(R.id.imageView22CalendarWorker);
            imageViewDatesWorker = (ImageView) itemView.findViewById(R.id.imageView19DatesWorker);
            imageViewEmailWorker = (ImageView) itemView.findViewById(R.id.imageView18EmailWorker);
            imageViewInfoWorker = (ImageView) itemView.findViewById(R.id.imageView23InfoWorker);
            imageViewTelephoneWorker = (ImageView) itemView.findViewById(R.id.imageView21TelephoneWorker);
            imageViewTrashWorker = (ImageView) itemView.findViewById(R.id.imageView20TrashWorker);
            imageViewPhotoWorker = (ImageView) itemView.findViewById(R.id.imageView17PhotoWorker);

            cardViewWorker =(CardView) itemView.findViewById(R.id.cardViewWorkerView);

            constraintLayoutCalendar = (ConstraintLayout) itemView.findViewById(R.id.ConstraintLayoutCalendar);
            constraintLayoutDates = (ConstraintLayout) itemView.findViewById(R.id.ConstraintLayoutDates);
            constraintLayoutInfoWorker = (ConstraintLayout) itemView.findViewById(R.id.ConstraintLayoutInfoWorker);
            constraintLayoutTelephone = (ConstraintLayout) itemView.findViewById(R.id.ConstraintLayoutTelephone);
            constraintLayoutEmail = (ConstraintLayout) itemView.findViewById(R.id.ConstraintLayoutEmail);

        }
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
