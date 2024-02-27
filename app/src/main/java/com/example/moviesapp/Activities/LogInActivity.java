package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviesapp.R;

public class LogInActivity extends AppCompatActivity {

    private EditText userEdt, passEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        
        initView();
    }

    private void initView() {
        userEdt = findViewById(R.id.editTextText4);
        passEdt = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(v -> {
            if (userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()) {
                Toast.makeText(LogInActivity.this, "Plase enter your username and password", Toast.LENGTH_SHORT).show();
            }else if (userEdt.getText().toString().equals("admin") && passEdt.getText().toString().equals("admin")) {
                startActivities(new Intent[]{new Intent(LogInActivity.this, MainActivity.class)});
            }else {
                Toast.makeText(LogInActivity.this, "Your username or password is not correct", Toast.LENGTH_SHORT).show();
            }
        });


    }




}