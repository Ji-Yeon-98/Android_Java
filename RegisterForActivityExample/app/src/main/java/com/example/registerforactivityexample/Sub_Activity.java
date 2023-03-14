package com.example.registerforactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText et_input = findViewById(R.id.et_input);

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strInputValue = et_input.getText().toString();

                //메인 액티비티로 다시 돌아갈 때 입력필드의 입력 값을 되돌려 준다.
                Intent intent = new Intent();
                intent.putExtra("value", strInputValue);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}