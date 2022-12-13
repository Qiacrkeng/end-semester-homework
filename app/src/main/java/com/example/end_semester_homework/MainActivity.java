package com.example.end_semester_homework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logic = findViewById(R.id.logic);
        Button register = findViewById(R.id.register);

        logic.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.logic){
            LogicActivity.actionStart(this);
        }else if(id == R.id.register){
            RegisterActivity.actionStart(this);
        }
    }
}