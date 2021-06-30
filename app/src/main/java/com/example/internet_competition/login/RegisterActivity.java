package com.example.internet_competition.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internet_competition.R;

import database.MyDatabaseHelper;

//  用于设计登录页面的活动

public class RegisterActivity extends AppCompatActivity {

    //数据库声明
    MyDatabaseHelper dbhelper;

    //部件声明
    private Button btnRegister;
    private Button btnCancel;
    private EditText mEtUsername;
    private EditText mEtPassword1;
    private EditText mEtPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //用户数据库实例化
        dbhelper = new MyDatabaseHelper(this, "UserInformation.db", null, 1);

        //部件绑定
        btnRegister = findViewById(R.id.R_register);
        btnCancel = (Button) findViewById(R.id.R_cancel);
        mEtUsername = findViewById(R.id.R_username);
        mEtPassword1 = findViewById(R.id.R_password);
        mEtPassword2 = findViewById(R.id.R_password2);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString();
                String password1 = mEtPassword1.getText().toString();
                String password2 = mEtPassword2.getText().toString();
                Intent intent = null;

                //会出现一下情况：1.用户名已存在，2.两次输入密码不一致
                if (!password1.equals(password2)) {
                    Toast.makeText(getApplicationContext(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                } else if (dbhelper.queryByUsername(username)) {
                    Toast.makeText(getApplicationContext(), "用户名已存在", Toast.LENGTH_SHORT).show();
                } else if (!dbhelper.queryByUsername(username)) {
                    ContentValues values =new ContentValues();
                    SQLiteDatabase db =dbhelper.getWritableDatabase();
                    values.put("username",username);
                    values.put("password",password1);
                    db.insert("User",null,values);
                    RegisterActivity.this.finish();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });
    }


}
