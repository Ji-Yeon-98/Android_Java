package com.example.backbuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0; //백버튼 눌렀을 때 시간

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //백버튼 눌렀을 때 뒤로가기 기능 활성화
    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis(); //현재시간 ms초로 설정
        long gapTime = curTime - backBtnTime; //현재 시간 - 백버튼 누른 시간 빼줌

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed();
        }else{
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}