package com.example.managmentrestarurantv2.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.managmentrestarurantv2.R;
import com.example.managmentrestarurantv2.business.model.User;
import com.example.managmentrestarurantv2.presentation.UserController;

public class RegisterActivity extends AppCompatActivity {
    private Button buttonRegister;
    private Button buttonBack;
    private EditText editTextEmail1;
    private EditText editTextEmail2;
    private EditText editTextPassword1;
    private EditText editTextPassword2;
    private Boolean succes = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //TODO Auto-generated method stub
            /*
            Enlazar los controles
             */
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (extracted()){
                    User user = new User();
                    user.setId_Usuario(editTextPassword2.getText().toString());
                    user.setEmail(editTextEmail2.getText().toString());
                    user.setTelefono("000000000");

                    UserController userController = new UserController();

                    if (userController.createUser(user)){
                        Intent intent = new Intent(RegisterActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                    }else {
                        //TODO
                    }

                }
            }

        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private Boolean extracted() {
        if (editTextEmail1.getText().toString().equals(editTextEmail2.getText().toString())){
            if (editTextPassword1.getText().toString().equals(editTextPassword2.getText().toString())){
                succes = true;
            }
        }
        return succes;
    }

}