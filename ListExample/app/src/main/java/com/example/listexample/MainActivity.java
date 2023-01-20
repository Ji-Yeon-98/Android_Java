package com.example.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listv = (ListView) findViewById(R.id.listv);

        //list 자료형 생성
        List<String> data = new ArrayList<>();

        //list data와 list view 연결하는 어뎁터
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data); //this : 여기 액티비티에 해당, simple_list_item : UI 디자인
        listv.setAdapter(adapter); //어뎁터를 list view에 연결

        data.add("추지연");
        data.add("android");
        data.add("app");
        adapter.notifyDataSetChanged(); //데이터 상태 저장 완료

    }
}