package com.example.broadcastreceiverexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv_state; //static 다른 클래스에서도 볼 수 있다.
    private NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_state = findViewById(R.id.tv_state);

        // 브로드 캐스트 리시버 등록! (그 중에서 네트워크 상태값 체크하는 기능만)
        // 명시적 인텐트 = 액티비티 이동 명명, 내가 기능을 가져다 쓰려는 목적 뚜렷
        // 인탠트 필터 = 내가 기능을 만들었으니까 알아서 이용하라는 것
        IntentFilter filter = new IntentFilter();
        receiver = new NetworkReceiver(); //객체 생성


        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION); // 네트워크 상태값을 인텐트 필터로 추가해라
        registerReceiver(receiver, filter); //브로드 캐스트 리시버 등록 (onReceive 동작)

    }


    //다른 액티비티로 넘어갈 때 해제
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //브로드 캐스트 리시버 해제
        unregisterReceiver(receiver);

    }
}