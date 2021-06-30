package com.example.internet_competition.learning;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internet_competition.R;

public class RecitewordsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recitewords);

        String book = getIntent().getStringExtra("book");
        Toast.makeText(getApplicationContext(), book, Toast.LENGTH_SHORT).show();


    }


}
