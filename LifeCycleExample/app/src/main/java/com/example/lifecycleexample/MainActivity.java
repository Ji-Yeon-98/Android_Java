package com.example.lifecycleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //액티비티가 최초로 생성될 때 어떠한 행동들을 해줄 것이냐
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view에다가 콘텐츠를 세팅 (res 폴더의 layout 폴더의 activity_main.xml을 연동)
        setContentView(R.layout.activity_main);

        // 액티비티 or 프래그먼트가 생성 되었을 때 이곳 내부 구문들을 실행
        Log.e("onCreate", "ENTER");

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> sub
                startActivity(new Intent(MainActivity.this, SubActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //액티비티가 화면에 보이기 직전에 호출되는 메소드
        Log.e("onStart", "ENTER");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 액티비티가 화면 상에 실제로 사용자에게 보여지고 있을 때 (사용자로부터 어떠한 동작도 받지 않았을 때)
        // B액티비티가 소멸이 되어 다시 A액티비티로 돌아왔을 때
        // 중지 되어있던 액티비티가 다시 재개(재실행)되는 시점에서 이곳 내부구문들을 실행
        Log.e("onResume", "ENTER");
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 액티비티가 다른 액티비로 전환
        // A액티비티에서 B액티비티로 넘어가 B액티비티가 쌓여있을 때 A 액티비티는 on pause 상태
        // 중지 상태일 때 이곳 내부 구문들을 실행 (홈 버튼을 눌러서 바깥으로 잠깐 빠져나갔을 때, 다른 액티비티가 활성화 되어있을 때)
        Log.e("onPause", "ENTER");
    }

    @Override
    protected void onStop() {
        super.onStop();

        // 체인지가 되고난 이후에 기존 액티비티와 다른 액티비티랑 완전히 바뀌어져서 기존 액티비티가 안보여지는 상태까지 도달할 때 호출
        // onStop까지 호출이 내려왔으면 onRestart -> onStart -> onResume
        Log.e("onStop", "ENTER");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // B액티비티에서 뒤로가기 눌러 finish 당했을 때
        // 화면이 파괴되어 소멸했을 때의 시점 일 때 이곳 내부 구문들을 실행
        Log.e("onDestroy", "ENTER");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "ENTER");
    }
}