package com.example.internet_competition;

//  主活动窗口，将来与我的页面合并，即登陆后直接为我的这个窗口

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internet_competition.learning.LearningActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;//先声明

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //给btn1，btn2赋值，即设置布局文件中的Button按钮id进行关联
        btn1 = (Button) findViewById(R.id.wode);
        btn2 = (Button) findViewById(R.id.wakuang);
        //为button绑定事件
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, wode.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(intent);
            }
        });
    }
}