package com.example.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//fragment : 한 액티비티에서 조각처럼 옷을 바꿔입는 것
public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity안에 있는 Fragment와 상호작용 및 관리를 위한 클래스
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                //framelayout을 fragment1로 교체해라 (예전 것을 제거한 뒤 보여줌)
                transaction.replace(R.id.frame, fragment1);
                transaction.commit(); //바꾼 다음에 저장, 새로고침
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                //framelayout을 fragment1로 교체해라
                transaction.replace(R.id.frame, fragment2);
                transaction.commit(); //바꾼 다음에 저장, 새로고침
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                //framelayout을 fragment1로 교체해라
                transaction.replace(R.id.frame, fragment3);
                transaction.commit(); //바꾼 다음에 저장, 새로고침
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment4 fragment4 = new Fragment4();
                //framelayout을 fragment1로 교체해라
                transaction.replace(R.id.frame, fragment4);
                transaction.commit(); //바꾼 다음에 저장, 새로고침
            }
        });

    }
}