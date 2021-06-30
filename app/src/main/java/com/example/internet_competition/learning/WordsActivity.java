package com.example.internet_competition.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.example.internet_competition.R;

public class WordsActivity extends AppCompatActivity {
    private TextView mEtWord, mEtWordId, mEtIPA, mEtMean, mEtExample;
    private Button btnAudio, btnUp, btnDown;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
    }
}