package com.example.internet_competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //数据库
    private MyDatabaseHelper dbHelper;

    //声明控件
    private Button btnLogin;
    private Button btnRegister;
    private Button btnFindPassword;
    private EditText mEtUsername;
    private EditText mEtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //数据库创建
        dbHelper = new MyDatabaseHelper(this, "UserInformation", null, 1);

        //找到控件
        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);
        btnFindPassword = findViewById(R.id.findPassword);
        mEtUsername = findViewById(R.id.username);
        mEtPassword = findViewById(R.id.password);

        //登录操作逻辑
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                Intent intent = null;

                //判断账号密码是否匹配，待完成
                if(dbHelper.queryByUsername(username, password)){
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "登录错误", Toast.LENGTH_SHORT).show();
                }
//                if(true){
//                    intent = new Intent(MainActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                }
            }
        });

        //注册按键逻辑
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username", username);
                values.put("password", password);

                //插入数据,第一个参数为表名
                //第二个参数用于在未指定添加数据的情况下给某些可为空的列自动赋值NULL
                db.insert("User", null, values);

                //清除数据,方便后续的查表操作
                values.clear();

            }
        });





    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}