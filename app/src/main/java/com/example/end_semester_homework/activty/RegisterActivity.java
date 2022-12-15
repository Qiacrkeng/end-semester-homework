package com.example.end_semester_homework.activty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.end_semester_homework.R;
import com.example.end_semester_homework.database.UserDBHelper;
import com.example.end_semester_homework.entity.User;
import com.example.end_semester_homework.util.ToastUtils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDBHelper mDBHelper;
    private EditText et_account;
    private EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_pwd);

        findViewById(R.id.btn_register).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDBHelper = UserDBHelper.getInstance(this);
        mDBHelper.openReadLink();
        mDBHelper.openWriteLink();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        String account = et_account.getText().toString();
        String pwd = et_pwd.getText().toString();
        int id = v.getId();
        if(id == R.id.btn_register){
            if(account.equals("")||pwd.equals("")){
                ToastUtils.show(this,"用户名和密码未填写");
            }else{
                if(mDBHelper.isExistsAccount(account)){
                    ToastUtils.show(this,"该用户名已经被注册过了");
                }else{
                    long acount = mDBHelper.addUser(new User(account, pwd));
                    Log.d("along","添加了"+acount+"条记录");
                    ToastUtils.show(this,"注册成功！即将返回登录界面");
                    LogicActivity.actionStart(this);
                }
            }
            
        }
    }
}