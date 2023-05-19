package com.cookandroid.project4_h_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch switchstart;
    RadioGroup rgroup1;
    RadioButton rdoO, rdoP, rdoQ;
    ImageView imgA;
    Button btnend, btnstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switchstart = (Switch) findViewById(R.id.Switchstart);

        text2 = (TextView) findViewById(R.id.Text2);
        rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoO = (RadioButton) findViewById(R.id.RdoO);
        rdoP = (RadioButton) findViewById(R.id.RdoP);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        imgA = (ImageView) findViewById(R.id.ImgA);

        btnend = (Button) findViewById(R.id.BtnEnd);
        btnstart = (Button) findViewById(R.id.BtnStart);

        switchstart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchstart.isChecked()==true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rgroup1.setVisibility(android.view.View.VISIBLE);
                    imgA.setVisibility(android.view.View.VISIBLE);
                    btnend.setVisibility(android.view.View.VISIBLE);
                    btnstart.setVisibility(android.view.View.VISIBLE);

                }else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rgroup1.setVisibility(android.view.View.INVISIBLE);
                    imgA.setVisibility(android.view.View.INVISIBLE);
                    btnend.setVisibility(android.view.View.INVISIBLE);
                    btnstart.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup rgroup1, int checkedId){
                if (checkedId == R.id.RdoO){
                    imgA.setImageResource(R.drawable.a);
                }else if(checkedId == R.id.RdoP){
                    imgA.setImageResource(R.drawable.b);
                }else if(checkedId == R.id.RdoQ){
                    imgA.setImageResource(R.drawable.c);
                }
            }
        });


        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgroup1.clearCheck();
                switchstart.toggle();
            }
        });



    }
}
