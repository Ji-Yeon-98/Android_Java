package com.cookandroid.project10_h_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        Button btnReulst = (Button) findViewById(R.id.btnResult);
        btnReulst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                final RadioGroup rgroup = (RadioGroup) findViewById(R.id.Rgroup);

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                switch (rgroup.getCheckedRadioButtonId()){
                    case R.id.rbtnAdd:
                        intent.putExtra("Cal", "+");
                        break;

                    case R.id.rbtnSub:
                        intent.putExtra("Cal", "-");
                        break;

                    case R.id.rbtnMul:
                        intent.putExtra("Cal", "*");
                        break;

                    case R.id.rbtnDiv:
                        intent.putExtra("Cal", "/");
                        break;
                }
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
