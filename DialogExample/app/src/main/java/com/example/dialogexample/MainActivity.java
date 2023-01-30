package com.example.dialogexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

//Dialog : 팝업창
public class MainActivity extends AppCompatActivity {

    Button btn_dialog;
    TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);//필수 세팅 : 다이얼로그 창에서 이미지 뷰로 띄울 아이콘
                ad.setTitle("제목");
                ad.setMessage("안녕하십니까?");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et); //다이얼로그 안에다가 EditText 객체 추가

                ad.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialogInterface.dismiss(); //모든 작업 실행 후 dialog 닫기
                    }
                });

                ad.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                ad.show(); //다이얼로그 실행

            }
        });

    }
}