package com.example.threadexample;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//스레드 : 백그라운드에서 작업을 할 수 있는 기능
//동시 작업을 위한 하나의 실행 단위, 메인 스레드 (앱의 기본 실행 담당)
//메인 스레드가 아닌 스레드가 리소스에 직접 접근하게 되면 문제 발생 =>입력 상자를 메인 스레드에서 접근하고 관리하고 있을 때 새로 만들어진 스레드에서 입력상자에 접근하면 데드락 발생
public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    Thread thread;
    boolean IsThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스레드 시작
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IsThread = true;
                thread = new Thread(){
                  public void run(){
                      while(IsThread){
                          try {
                              sleep(5000); //일시정지, 5초 동안 잠깐 쉬어라
                          } catch (InterruptedException e) {
                              e.printStackTrace(); //예외 처리
                          }
                          handler.sendEmptyMessage(0); //핸들러에 빈 메세지를 보냄

                      }
                    }
                };

                thread.start(); //스레드 실제 시작
            }
       });

        //스레드 종료
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsThread = false;
            }
        });

    }

    //핸들러 : 별도의 제어를 통해 UI부분을 다루기 위한 장치
    //다른 스레드에서 요청하는 정보를 메세지 큐를 통해 순서대로 실행
    private Handler handler = new Handler(){
        //Ctrl + O
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "추지연", Toast.LENGTH_SHORT).show();
        }
    };
}