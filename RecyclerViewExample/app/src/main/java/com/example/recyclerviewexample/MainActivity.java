package com.example.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


//recycler view란 목록을 화면에 출력해주고 동적으로 표현해주는 컨테이너
//표시될 데이터와 아이템 레이아웃을 어댑터에서 연결
public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml의 recyclerview 선언
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        //arraylist를 어뎁터에 담아줌
        mainAdapter = new MainAdapter(arrayList);
        //담아져있는 데이터의 어뎁터를 recyclerview에 세팅
        recyclerView.setAdapter(mainAdapter);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //데이터 생성
                MainData mainData = new MainData(R.mipmap.ic_launcher, "추지연", "hi");
                //arraylist에 데이터 넣어주기
                arrayList.add(mainData);
                //새로고침
                mainAdapter.notifyDataSetChanged();
            }
        });

    }
}