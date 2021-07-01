package com.example.internet_competition.learning;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internet_competition.R;

import database.MyDatabaseHelper;
import database.WordsDatabaseHelper;

public class RecitewordsActivity extends AppCompatActivity {

    //数据库
    private WordsDatabaseHelper dbHelper;

    // 部件声明
    private Button btnchinese1, btnchinese2, btnchinese3, btnchinese4;
    private TextView eMtenglish, eMtpartofspeech;

    // 测试使用
    String[] twords = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
    String[] tnum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
    Random r = new Random();
    String word1, word2, word3, word4, rword, enword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recitewords);

        // 第一部分选择数据库
        String book = getIntent().getStringExtra("book");
        Toast.makeText(getApplicationContext(), book, Toast.LENGTH_SHORT).show();
        if (book.equals("Cet4")) {
            //dbHelper = new WordsDatabaseHelper()
        } else if (book.equals("Cet6")) {
            //dbHelper = new WordsDatabaseHelper()
        }
        // 绑定部件
        btnchinese1 = (Button) findViewById(R.id.chinese1);
        btnchinese2 = (Button) findViewById(R.id.chinese2);
        btnchinese3 = (Button) findViewById(R.id.chinese3);
        btnchinese4 = (Button) findViewById(R.id.chinese4);
        eMtenglish = findViewById(R.id.english);
        eMtpartofspeech = findViewById(R.id.partofspeech);

        getwords();
        resetbutton();

        // 第二部分绑定控件事件
        btnchinese1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word1.equals(rword)){
                    Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                }
                getwords();
                resetbutton();
            }
        });
        btnchinese2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word2.equals(rword)){
                    Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                }
                getwords();
                resetbutton();
            }
        });
        btnchinese3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word3.equals(rword)){
                    Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                }
                getwords();
                resetbutton();
            }
        });
        btnchinese4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word4.equals(rword)){
                    Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                }
                getwords();
                resetbutton();
            }
        });
    }

    void getwords() {
        int n =r.nextInt(13)+1,flag = r.nextInt(4)+1,m;
        enword = twords[n];
        rword = tnum[n];

        word1 = tnum[r.nextInt(n)];
        word2 = tnum[r.nextInt(n)];
        word3 = tnum[r.nextInt(13-n)+n];
        word4=tnum[r.nextInt(13-n)+n];
        // 对四个word产生一个随机正确答案
        switch (flag){
            case 1:
                word1=rword;
                break;
            case 2:
                word2=rword;
                break;
            case 3:
                word3=rword;
                break;
            case 4:
                word4=rword;
                break;
        }
    }

    void resetbutton() {
        eMtenglish.setText(enword);
        btnchinese1.setText(word1);
        btnchinese2.setText(word2);
        btnchinese3.setText(word3);
        btnchinese4.setText(word4);
    }


}
