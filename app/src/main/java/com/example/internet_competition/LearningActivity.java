package com.example.internet_competition;

// 用于设计背单词挖矿活动页面

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LearningActivity extends AppCompatActivity {
    Button but_return,but_start,but_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);



        // 返回button
        but_return = (Button) findViewById(R.id.fanhui);
        but_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearningActivity.this.finish();
            }
        });
    }

}