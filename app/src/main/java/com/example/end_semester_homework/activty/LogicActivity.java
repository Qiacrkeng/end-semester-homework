package com.example.end_semester_homework.activty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.end_semester_homework.R;
import com.example.end_semester_homework.database.UserDBHelper;
import com.example.end_semester_homework.entity.User;
import com.example.end_semester_homework.util.ToastUtils;

public class LogicActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_account;
    private EditText et_pwd;
    private UserDBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());

        setContentView(R.layout.activity_logic);


        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_pwd);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mDBHelper = UserDBHelper.getInstance(this);
        mDBHelper.openReadLink();
        mDBHelper.openWriteLink();
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context, LogicActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        String account = et_account.getText().toString();
        String pwd = et_pwd.getText().toString();
        int id = v.getId();
        if(id == R.id.btn_login){
            if(account.equals("")||pwd.equals("")){
                ToastUtils.show(this,"用户名或密码未填写");
            }else{
                if(mDBHelper.isExistsAccount(account)){
                    User user = mDBHelper.selectByAccount(account);
                    if(account.equals(user.getAccount()) && pwd.equals(user.getPassword())){
                        ToastUtils.show(this,"登录成功");
                        Intent intent = new Intent(this,HomeActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.show(this,"用户名或密码错误");
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("用户名不存在，请先注册");
                    builder.setPositiveButton("立即去注册", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            RegisterActivity.actionStart(LogicActivity.this);
                        }
                    });
                    builder.setNegativeButton("我再看看",null);
                    builder.create().show();
                }

            }
        }
    }
}