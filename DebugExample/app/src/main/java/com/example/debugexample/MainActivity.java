package com.example.debugexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String chu = "추지연";

        //log 에러 형태로 출력 => logcat 중 error에서 확인 가능
        Log.e("MainActivity : ", chu);

        /*
        int a = 10;
        Log.e("MainActivity", String.valueOf(a));
        */


    }
}