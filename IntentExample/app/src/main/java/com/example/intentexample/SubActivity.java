package com.example.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); //인텐드로 날라오는 데이터가 있으면 받겠다.
        String str = intent.getStringExtra("str"); //String 형태로 오는 데이터를 받는다. (별명이 str인 데이터)

        tv_sub.setText(str);

    }
}