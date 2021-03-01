package com.example.lab2mtrfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText meditTextUsername, meditTextPassword;
    private Button mbtnLogin, mbtnReset;
    private String username = "mano";
    private String password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        meditTextUsername = findViewById(R.id.editTextUsername);
        meditTextPassword = findViewById(R.id.editTextPassword);

        mbtnLogin = findViewById(R.id.btnLogin);
        mbtnReset = findViewById(R.id.btnReset);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String inputUsername = meditTextUsername.getText().toString();
                String inputPassword = meditTextPassword.getText().toString();

                if(inputUsername.equals(username) && inputPassword.equals(password)){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    Login.this.startActivity(intent);
                } else{
                    Toast.makeText(Login.this, "Login Unsuccessful!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mbtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meditTextUsername.setText("");
                meditTextPassword.setText("");
                meditTextUsername.requestFocus();
                Toast.makeText(Login.this, "Field reset Done..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}