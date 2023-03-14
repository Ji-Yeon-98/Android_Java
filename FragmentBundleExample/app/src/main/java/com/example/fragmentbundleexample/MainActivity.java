package com.example.fragmentbundleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MainActivity으므로 getActivity 사용 X
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //transaction : 프래그먼트 관리하는 것 (교체, 가져오기, 현재 값들 검사)
        Fragment1 fragment1 = new Fragment1();
        transaction.replace(R.id.framelayout, fragment1); //교체할 화면의 영역, 교체할 화면
        transaction.commit(); // fragment 상태 저장
    }
}