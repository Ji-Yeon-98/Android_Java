package com.example.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_text;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);

        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //edittext에 무엇인가가 적어지면 텍스트를 가져온다. + String 형태로 변환
                str = et_text.getText().toString();

                //this : 현재 자기자신 + 두번째 인자는 class
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str); //인텐트에 데이터를 실어서 보내준다. 첫번째 인자 : 별명 + 두번째 인자 : 실제 데이터
                startActivity(intent); //액티비티 이동
            }
        });

    }
}