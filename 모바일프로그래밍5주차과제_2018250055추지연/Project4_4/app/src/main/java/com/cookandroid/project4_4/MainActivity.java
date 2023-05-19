package com.cookandroid.project4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnReminder;
    TextView textresult;
    String num1, num2;
    Float result;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnReminder = (Button) findViewById(R.id.btnRemainder);

        textresult = (TextView) findViewById(R.id.textresult);

        toast = Toast.makeText(getApplicationContext(), "오류 : 값을 입력하세요.", Toast.LENGTH_LONG);

        setTitle("초간단 계산기(수정)");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(!num1.isEmpty() && !num2.isEmpty()){
                    result = Float.parseFloat(num1) + Float.parseFloat(num2);
                    textresult.setText("계산 결과 : " + result.toString());
                }
                else {
                    toast.show();
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(!num1.isEmpty() && !num2.isEmpty()){
                    result = Float.parseFloat(num1) - Float.parseFloat(num2);
                    textresult.setText("계산 결과 : " + result.toString());
                }
                else {
                    toast.show();
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(!num1.isEmpty() && !num2.isEmpty()){
                    result = Float.parseFloat(num1) * Float.parseFloat(num2);
                    textresult.setText("계산 결과 : " + result.toString());
                }
                else {
                    toast.show();
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(!num1.isEmpty() && !num2.isEmpty()){
                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
                    textresult.setText("계산 결과 : " + result.toString());
                }
                else {
                    toast.show();
                }
            }
        });

        btnReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(!num1.isEmpty() && !num2.isEmpty()){
                    result = Float.parseFloat(num1) % Float.parseFloat(num2);
                    textresult.setText("계산 결과 : " + result.toString());
                }
                else {
                    toast.show();
                }
            }
        });

    }

}
