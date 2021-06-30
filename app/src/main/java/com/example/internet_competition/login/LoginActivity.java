package com.example.internet_competition.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.internet_competition.R;
import com.example.internet_competition.MainActivity;

import database.MyDatabaseHelper;

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
        dbHelper = new MyDatabaseHelper(this, "UserInformation.db", null, 1);

        //找到控件
        btnLogin = findViewById(R.id.L_login);
        btnRegister = findViewById(R.id.L_register);
        btnFindPassword = findViewById(R.id.L_findPassword);
        mEtUsername = findViewById(R.id.L_username);
        mEtPassword = findViewById(R.id.L_password);

        //登录操作逻辑
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                Intent intent = null;

                //判断账号密码是否匹配，待完成
                int flag = dbHelper.queryByUser(username, password);
                if(flag==1){
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    LoginActivity.this.finish();
                }
                else if(flag == 0){
                    Toast.makeText(getApplicationContext(), "登录错误", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "请输入账号密码", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
//                String username = mEtUsername.getText().toString();
//                String password = mEtPassword.getText().toString();
//
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("username", username);
//                values.put("password", password);
//
//                //插入数据,第一个参数为表名
//                //第二个参数用于在未指定添加数据的情况下给某些可为空的列自动赋值NULL
//                db.insert("User", null, values);
//
//                //清除数据,方便后续的查表操作
//                values.clear();

            }
        });

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }
    /**
     * 获取InputMethodManager，隐藏软键盘
     * @param token
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }


}