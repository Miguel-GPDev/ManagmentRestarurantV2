package com.example.managmentrestarurantv2.integration.impl;

import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.WorkerRepositoryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class WorkerRepositoryFirebaseImpl implements WorkerRepositoryFirebase {
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    String idUser;


    @Override
    public Boolean create(Worker worker) {
        return null;
    }

    @Override
    public void read(String idWorker, CallBackFirebase callBackFirebase) {

    }

    @Override
    public Boolean update(String idWorker) {
        return null;
    }

    @Override
    public Boolean delete(String idWorker) {
        return null;
    }

    @Override
    public void getAll(String idUser, CallBackFirebase callBackFirebase) {

    }
}
