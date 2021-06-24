package com.example.internet_competition;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "password text)";

    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);//执行建表语句
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean queryByUsername(String targetUsername, String targetPassword){
        boolean flag = false;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("User", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));

                if (username.equals(targetUsername)){
                    if(password.equals(targetPassword))
                        flag = true;
                }
            } while(cursor.moveToNext());
        }
        cursor.close();
        return flag;
    }
}
