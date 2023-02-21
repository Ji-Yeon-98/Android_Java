package com.example.videoviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView; // 비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; // 재생, 정지와 같은 미디어 제어 버튼부를 담당

    @Override
    protected void onCreate(Bundle savedInstanceState) { //앱이 첫 실행이 됐을 때 이곳을 수행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView); // 비디오 뷰 아이디 연결
        Uri videoUri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        // 내 앱에 있는 영상을 보여주고 싶다면 raw 파일에 동영상을 넣고 uri 주소 바꾸기
        // Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.trailer);

        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController); // 컨트롤 바를 비디오 뷰에 붙여줌
        videoView.setVideoURI(videoUri); // 비디오 뷰가 보여줄 동영상 경로 주소 설정

        //동영상을 읽어오는데 시간이 걸리므로 비디오 로딩 준비가 끝났을 때 실행
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
            }
        });

    }

    // 화면에 안보일 때
    @Override
    protected void onPause() {
        super.onPause();

        if(videoView != null && videoView.isPlaying()){
            videoView.pause();
        }
    }

    //액티비티가 메모리에서 사라질 때
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null){
            videoView.stopPlayback();
        }
    }
}