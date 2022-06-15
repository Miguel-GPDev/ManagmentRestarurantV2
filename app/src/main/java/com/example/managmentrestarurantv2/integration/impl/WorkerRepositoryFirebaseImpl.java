package com.example.managmentrestarurantv2.integration.impl;

import androidx.annotation.NonNull;

import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.WorkerRepositoryFirebase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerRepositoryFirebaseImpl implements WorkerRepositoryFirebase {
    FirebaseAuth mAuth;
    private FirebaseFunctions mFunctions;
    DatabaseReference databaseReference;
    String idUser;


    @Override
    public Task<String> create(Worker worker) {
        mFunctions = FirebaseFunctions.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String id = databaseReference.push().getKey();




        worker.setId(id);

        databaseReference.child("Users")
                .child(worker.getIdBoss())
                .child("Workers")
                .setValue(worker);

        databaseReference.child("Workers")
                .child(clearEmail(worker.getEmail()))
                .child(worker.getId())
                .setValue(worker);

        Map<String, Object> data = new HashMap<>();
        data.put("id", worker.getId());
        data.put("email", worker.getEmail());
        data.put("nif", worker.getNif());
        data.put("name", worker.getName());
        return mFunctions
                .getHttpsCallable("createWorker")
                .call(data)
                .continueWith(new Continuation<HttpsCallableResult, String>() {
                    @Override
                    public String then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                        // This continuation runs on either success or failure, but if the task
                        // has failed then getResult() will throw an Exception which will be
                        // propagated down.
                        String result = (String) task.getResult().getData();
                        return result;
                    }
                });
    }

    private String clearEmail(String email) {
        String emailClean = email.replace(".","");
        emailClean = emailClean.replace("#","");
        emailClean = emailClean.replace("$","");
        emailClean = emailClean.replace("[","");
        emailClean = emailClean.replace("]","");
        return emailClean;
    }

    @Override
    public void read(String idWorker, CallBackFirebase callBackFirebase) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(mAuth.getUid()).child(idWorker)
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                callBackFirebase.onSuccess(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public Boolean update(Worker worker) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("Workers")
                .child(worker.getEmail())
                .setValue(worker).isSuccessful();
    }

    @Override
    public Boolean delete(String idWorker) {
        //TODO
        return null;
    }

    @Override
    public List<Worker> getAll(String idUser, CallBackFirebase callBackFirebase) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Users").child(idUser).child("Workers")
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                callBackFirebase.onSuccess(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return null;
    }
}
