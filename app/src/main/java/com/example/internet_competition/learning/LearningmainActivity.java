package com.example.internet_competition.learning;

// 用于设计背单词挖矿活动页面

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internet_competition.R;

public class LearningmainActivity extends AppCompatActivity {
    // 部件声明
    Button btnReturn,btnCet4,btnCet6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningmain);

        // 绑定button
        btnReturn = (Button) findViewById(R.id.cancel);
        btnCet4=(Button)findViewById(R.id.btncet4);
        btnCet6=(Button)findViewById(R.id.btncet6);

        // 绑定响应事件
        // 返回键事件
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearningmainActivity.this.finish();
            }
        });

        // cet4键事件
        btnCet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningmainActivity.this, RecitewordsActivity.class);
                intent.putExtra("book","Cet4");
                startActivity(intent);
            }
        });

        // cet6键事件
        btnCet6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningmainActivity.this, RecitewordsActivity.class);
                intent.putExtra("book","Cet6");
                startActivity(intent);
            }
        });

    }

}