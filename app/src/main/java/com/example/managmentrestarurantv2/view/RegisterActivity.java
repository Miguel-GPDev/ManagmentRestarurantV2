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

        buttonRegister = (Button) findViewById(R.id.buttonSignIn);
        buttonBack = (Button)findViewById(R.id.buttonCancel);

        editTextEmail1 = (EditText) findViewById(R.id.editTextEmail1);
        editTextEmail2 = (EditText) findViewById(R.id.editTextEmail2);
        editTextPassword1 = (EditText) findViewById(R.id.editTextPassword1);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (extracted()){
                    User user = new User();
                    user.setId(editTextPassword2.getText().toString());
                    user.setEmail(editTextEmail2.getText().toString());
                    user.setTelefono("000000000");
                    user.setType("1");
                    user.setVariable1("empty");
                    user.setVariable2("empty");

                    UserController userController = new UserController();
                    userController.createUser(user);
                    onBackPressed();
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