package com.example.checkboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk_red, chk_blue, chk_green;
    private TextView tv_result;
    private Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk_red = findViewById(R.id.chk_red);
        chk_blue = findViewById(R.id.chk_blue);
        chk_green = findViewById(R.id.chk_green);
        tv_result = findViewById(R.id.tv_result);
        btn_result = findViewById(R.id.btn_result);

        //결과 버튼을 클릭했을 때 액션
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_result = ""; // String 값 초기화 (공백의 값 넣어줌)

                //체크 박스에 체크가 되어있다면
                if(chk_red.isChecked()){
                    str_result += chk_red.getText().toString(); //String 값에 빨강을 추가해줌
                }
                if(chk_blue.isChecked()){
                    str_result += chk_blue.getText().toString(); //String 값에 파랑을 추가해줌
                }
                if(chk_green.isChecked()){
                    str_result += chk_green.getText().toString(); //String 값에 초록록을 추가해줌
                }

                tv_result.setText(str_result); //체크박스에 체크되어있던 값을 string으로 텍스트뷰에 출력

           }
        });

    }
}