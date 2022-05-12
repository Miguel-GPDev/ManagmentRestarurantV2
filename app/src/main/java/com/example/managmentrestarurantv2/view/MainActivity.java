package com.example.managmentrestarurantv2.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.managmentrestarurantv2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button buttonSigIn;
    Button buttonRegister;
    Button buttonEmployed;
    EditText editTextViewUser;
    EditText editTextViewPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Auto-generated method stub
            /*
            Enlazar los controles
             */
        buttonSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(1);
            }
        });
        buttonEmployed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(2);
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

    private void signIn(int tipe) {
        String user = editTextViewUser.getText().toString();
        String password = editTextViewPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    if (tipe == 1){
                        mAuth = FirebaseAuth.getInstance();
                        Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(MainActivity.this, DashBoardWorkerActivity.class);
                        startActivity(intent);
                    }

                }else {
                    //TODO
                }
            }
        });
    }
}