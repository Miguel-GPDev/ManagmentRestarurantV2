package com.example.managmentrestarurantv2.integration;

import com.example.managmentrestarurantv2.business.model.Worker;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface WorkerRepositoryFirebase {
    Task<String> create (Worker worker);
    void read (String idWorker, CallBackFirebase callBackFirebase);
    Boolean update (Worker worker);
    Boolean delete (String idWorker);
    List<Worker> getAll (String idUser, CallBackFirebase callBackFirebase);
}
