package com.example.serviceexample;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //ctrl + o
    //서비스 처음 시작될 때 초기화
    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.minneapolis); //현재 자기 자신, 음악 파일 생성
        mediaPlayer.setLooping(false); //반복 재생 X
    }

    //음악 시작
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    //서비스가 끝났을 때
    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();

    }
}

//manifests에 <service android:name=".MusicService"/> 추가