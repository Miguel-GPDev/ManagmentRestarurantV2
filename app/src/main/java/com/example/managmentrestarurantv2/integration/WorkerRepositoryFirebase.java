package com.example.managmentrestarurantv2.integration;

import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.model.Worker;

public interface WorkerRepositoryFirebase {
    Boolean create (Worker worker);
    void read (String idWorker, CallBackFirebase callBackFirebase);
    Boolean update (String idWorker);
    Boolean delete (String idWorker);
    void getAll (String idUser, CallBackFirebase callBackFirebase);
}
