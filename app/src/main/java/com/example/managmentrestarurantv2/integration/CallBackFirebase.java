package com.example.managmentrestarurantv2.integration;

import com.example.managmentrestarurantv2.business.model.User;
import com.google.firebase.database.DataSnapshot;

public interface CallBackFirebase {
    void onSuccess(DataSnapshot dataSnapshot);
    void onStart();
    void onFailure();
}
