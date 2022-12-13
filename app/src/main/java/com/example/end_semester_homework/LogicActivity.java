package com.example.end_semester_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

public class LogicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());

        setContentView(R.layout.activity_logic);
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context, LogicActivity.class);
        context.startActivity(intent);
    }

}