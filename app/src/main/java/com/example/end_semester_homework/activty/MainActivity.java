package com.example.end_semester_homework.activty;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.end_semester_homework.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.logic);
        Button registerBtn = findViewById(R.id.register);

        loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LogicActivity.class));
        });
        registerBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });
    }
}