package com.example.sharedexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save);

        //앱이 꺼져도 데이터값 저장
        SharedPreferences sharedPreferences = getSharedPreferences("file", 0); //첫번째 인자 : 별명, 두번째 인자 : 읽고 쓰기 관련된 모드
        String value = sharedPreferences.getString("ettext", ""); //꺼내오는 것이므로 빈 값 입력
        et_save.setText(value);

    }

    //앱 종료시켰을 때, 액티비티를 벗어났을 때 실행
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //앱 종료 전에 데이터 저장
        SharedPreferences sharedPreferences = getSharedPreferences("file", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //sharedPreference와 에디터와 연결
        String value = et_save.getText().toString();
        editor.putString("ettext", value); //데이터 저장
        editor.commit(); //실제적인 저장 코드
    }
}