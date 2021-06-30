package com.example.internet_competition;

// 用于设计背单词挖矿活动页面

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import database.user_data;

import androidx.appcompat.app.AppCompatActivity;

public class wakuang extends AppCompatActivity {
    Button but_return,but_start,but_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wakuang);

        // 从MainActivity接受用户对象，用于修改和实现功能
        user_data user = (user_data) getIntent().getSerializableExtra("user_data");
        // 用于接收单词
        String[][] sorce;
        sorce = user.getRandomWords();
        


        // 返回button
        but_return = (Button) findViewById(R.id.fanhui);
        but_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wakuang.this.finish();
            }
        });
    }

}