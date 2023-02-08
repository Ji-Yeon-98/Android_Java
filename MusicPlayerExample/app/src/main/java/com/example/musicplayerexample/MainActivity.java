package com.example.musicplayerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    Button btn_play;
    Button btn_stop;

    MediaPlayer mediaPlayer;

    // 액티비티가 종료될 때 이곳을 실행
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){ //미디어 플레이거가 아무것도 가지고 있지않으면
            mediaPlayer.release(); //객체를 완전히 파괴하여 더 이상 사용할 수 없는 상태로 만듦
            mediaPlayer = null; //미디어 플레이어 초기화
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_stop = (Button) findViewById(R.id.btn_stop);

        //재생 버튼 눌렀을 때
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
                mediaPlayer.start();
            }
        });

        //정지 버튼 눌렀을 때
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){ //현재 음악이 재생중인지
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });



    }
}