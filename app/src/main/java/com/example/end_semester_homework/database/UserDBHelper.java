package com.example.end_semester_homework.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.end_semester_homework.entity.User;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    private static final String TABLE_NAME = "user";
    private static final int VERSION  = 1;
    private static UserDBHelper mDBHelper;
    private SQLiteDatabase mRDB;
    private SQLiteDatabase mWDB;

    public UserDBHelper(Context context){
        super(context,DB_NAME,null,VERSION);
    }

    public static UserDBHelper getInstance(Context context){
        if(mDBHelper == null){
            mDBHelper = new UserDBHelper(context);
        }
        return mDBHelper;
    }


    public SQLiteDatabase openReadLink(){
        if(mRDB == null || !mRDB.isOpen()){
            mRDB = mDBHelper.getReadableDatabase();
        }
        return mRDB;
    }

    public SQLiteDatabase openWriteLink(){
        if(mWDB == null || !mWDB.isOpen()){
            mWDB = mDBHelper.getReadableDatabase();
        }
        return mWDB;
    }


    public void close(){
        if(mRDB != null && mRDB.isOpen()){
            mRDB.close();
            mRDB = null;
        }

        if(mWDB != null && mWDB.isOpen()){
            mWDB.close();
            mWDB = null;
        }
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("along","adsgasdg");
        String sql = "create table if not exists user(" +
                "       id integer primary key autoincrement," +
                "       account varchar not null," +
                "       password varchar not null" +
                ");";
        db.execSQL(sql);

        String manager = "insert into user values(null,'manager','123456')";
        db.execSQL(manager);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addUser(User user){
        ContentValues values = new ContentValues();
        values.put("account",user.getAccount());
        values.put("password",user.getPassword());
        return mWDB.insert(TABLE_NAME, null, values);
    }


    public boolean isExistsAccount(String account){
        Cursor cursor = mRDB.rawQuery("select * from user where account = ?", new String[]{account});
        boolean isExists = cursor.moveToFirst();
        cursor.close();
        return isExists;
    }

    public User selectByAccount(String account){
        User user = null;
        Cursor cursor = mRDB.rawQuery("select * from user where account = ?", new String[]{account});
        if(cursor.moveToFirst()){
            user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        cursor.close();
        return user;
    }

}
