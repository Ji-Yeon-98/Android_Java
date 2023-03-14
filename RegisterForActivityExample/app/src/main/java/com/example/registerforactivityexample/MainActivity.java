package com.example.registerforactivityexample;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub_Activity.class);
                getSubActivityResult.launch(intent); // startActivityForResult와 동일한 기능
            }
        });

    }

    //sub activity 수행되고 main activity로 돌아왔을 때 (다양한 버튼 or 액티비티가 존재할 때는 변수명을 다르게 생성해 구현)
    private final ActivityResultLauncher<Intent> getSubActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //서브 액티비티로부터 돌아올 때의 서브 액티비티에서 벌어지는 어떠한 결과 값을 받아올 수 있는 통로
                if(result.getResultCode() == RESULT_OK){
                    // 서브 액티비티의 입력값을 메인에서 받아서 텍스트뷰에 표시
                    tv_result.setText(result.getData().getStringExtra("value"));
                }
            }
    );

}