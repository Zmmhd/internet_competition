package com.example.internet_competition.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.internet_competition.R;

import database.MyDatabaseHelper;
import database.NewWordsDatabaseHelper;
import database.WordsDatabaseHelper;

public class WordsActivity extends AppCompatActivity {
    private TextView mEtWord, mEtWordId, mEtIPA, mEtInterpretation, mEtExample;
    private Button btnAudio, btnUp, btnDown;
    NewWordsDatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

/*        //记录在这个页面显示过的单词
        String[] wordsList = new String[20];
        //currentIndex表示当前单词的索引，tempIndex表示最后一个单词的索引
        int currentIndex = -1, tempIndex = -1;*/

        dbHelper = new NewWordsDatabaseHelper(this, "NewWord.db", null, 1);
        mEtWord = findViewById(R.id.words);
        btnDown = findViewById(R.id.btn_down);
        btnUp = findViewById(R.id.btn_up);


        String showWord = dbHelper.getFirstWord();
        if(showWord.isEmpty()){
            Toast.makeText(getApplicationContext(), "你全都会了！", Toast.LENGTH_SHORT).show();
        }else{


            mEtWord.setText(showWord);
            btnDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentWord = mEtWord.getText().toString();

                    currentWord = dbHelper.getNextWord(currentWord);
                    mEtWord.setText(currentWord);

                }
            });


            btnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentWord = mEtWord.getText().toString();
                    currentWord = dbHelper.getPreviousWord(currentWord);
                    mEtWord.setText(currentWord);
                }
            });
        }


    }
}