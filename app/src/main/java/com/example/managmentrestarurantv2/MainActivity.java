package com.example.managmentrestarurantv2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.managmentrestarurantv2.business.model.Bar;
import com.example.managmentrestarurantv2.business.model.Booking;
import com.example.managmentrestarurantv2.business.model.Client;
import com.example.managmentrestarurantv2.business.model.Kitchen;
import com.example.managmentrestarurantv2.business.model.MenuRestaurant;
import com.example.managmentrestarurantv2.business.model.Product;
import com.example.managmentrestarurantv2.business.model.Restaurant;
import com.example.managmentrestarurantv2.business.model.SupplierRestaurant;
import com.example.managmentrestarurantv2.business.model.Table;
import com.example.managmentrestarurantv2.business.model.User;
import com.example.managmentrestarurantv2.business.model.Worker;
import com.example.managmentrestarurantv2.integration.CallBackFirebase;
import com.example.managmentrestarurantv2.integration.RestaurantRepositoryFirebase;
import com.example.managmentrestarurantv2.integration.impl.RestaurantRepositoryFirebaseImpl;
import com.example.managmentrestarurantv2.integration.impl.UserRepositoryFirebaseImpl;
import com.example.managmentrestarurantv2.view.DashBoardActivity;
import com.example.managmentrestarurantv2.view.DashBoardWorkerActivity;
import com.example.managmentrestarurantv2.view.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button buttonSigIn;
    Button buttonRegister;
    Button buttonEmployed;
    EditText editTextUser;
    EditText editTextPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        buttonSigIn = (Button) findViewById(R.id.buttonSignIn1);
        buttonRegister = (Button) findViewById(R.id.buttonRegister1);
        buttonEmployed = (Button) findViewById(R.id.buttonWorker1);
        editTextUser = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        buttonEmployed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void signIn() {
        String user = editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    verifyTypeOfUser();
                }else {
                    //TODO
                }
            }
        });
    }

    private void verifyTypeOfUser() {
        mAuth = FirebaseAuth.getInstance();
        UserRepositoryFirebaseImpl userRepositoryFirebase = new UserRepositoryFirebaseImpl();
        userRepositoryFirebase.read(mAuth.getUid(), new CallBackFirebase() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                User user = new User();
                user = dataSnapshot.getValue(User.class);

                if (user.getType().toString().equals("1")){
                    Intent intent1 = new Intent(MainActivity.this, DashBoardActivity.class);
                    startActivity(intent1);
                }else {
                    Intent intent2 = new Intent(MainActivity.this, DashBoardWorkerActivity.class);
                    startActivity(intent2);
                }
            }
            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
    }
}