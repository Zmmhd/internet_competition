package com.example.internet_competition;

//  我的页面，主要用来显示用户信息，和一个排行榜入口

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class wode extends AppCompatActivity {
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode);
        but = (Button) findViewById(R.id.fanhui);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wode.this.finish();
            }
        });
    }

}
