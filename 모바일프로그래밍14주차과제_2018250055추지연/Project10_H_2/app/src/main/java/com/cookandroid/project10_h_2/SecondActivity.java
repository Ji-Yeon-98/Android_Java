package com.cookandroid.project10_h_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        final int num1 = inIntent.getIntExtra("Num1", 0);
        final int num2 = inIntent.getIntExtra("Num2", 0);
        final String cal = inIntent.getStringExtra("Cal");

        int result = 0;
        if(cal.equals("+")){
            result = num1 + num2;
        }else if(cal.equals("-")){
            result = num1 - num2;
        }else if(cal.equals("*")){
            result = num1 * num2;
        }else if(cal.equals("/")){
            result = num1 / num2;
        }


        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        final int finalresult = result;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("result", finalresult);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }
}
