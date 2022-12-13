package com.example.end_semester_homework.util;


import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private ToastUtils(){}

    public static void show(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }

}
