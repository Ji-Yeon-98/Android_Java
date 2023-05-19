package com.cookandroid.project7_h_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button btn1, btnDog, btnCat;
    View dogView, catView, RabbitView, HorseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-6");

        rg = (RadioGroup) findViewById(R.id.RdoGroup);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.Rdodog:
                        dogView = (View) View.inflate(MainActivity.this, R.layout.dog_xml, null);
                        AlertDialog.Builder dog = new AlertDialog.Builder(MainActivity.this);
                        btnDog = (Button) dogView.findViewById(R.id.btnDog);
                        dog.setTitle("강아지");
                        dog.setView(dogView);
                        final DialogInterface dogstart = dog.show();
                        btnDog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dogstart.dismiss();
                            }
                        });
                        break;

                    case R.id.Rdocat:
                        catView = (View) View.inflate(MainActivity.this, R.layout.cat, null);
                        AlertDialog.Builder cat = new AlertDialog.Builder(MainActivity.this);
                        btnCat = (Button) catView.findViewById(R.id.btnCat);
                        cat.setTitle("고양이");
                        cat.setView(catView);
                        final DialogInterface catstart = cat.show();
                        btnCat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                catstart.dismiss();
                            }
                        });
                        break;

                    case R.id.Rdorabbit:
                        RabbitView = (View) View.inflate(MainActivity.this, R.layout.rabbit, null);
                        AlertDialog.Builder rabbit = new AlertDialog.Builder(MainActivity.this);
                        rabbit.setTitle("토끼");
                        rabbit.setView(RabbitView);
                        rabbit.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        rabbit.show();
                        break;

                    case R.id.Rdohorse:
                        HorseView = (View) View.inflate(MainActivity.this, R.layout.horse, null);
                        AlertDialog.Builder horse = new AlertDialog.Builder(MainActivity.this);
                        horse.setTitle("말");
                        horse.setView(HorseView);
                        horse.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        horse.show();
                        break;
                }
            }
        });

    }
}
