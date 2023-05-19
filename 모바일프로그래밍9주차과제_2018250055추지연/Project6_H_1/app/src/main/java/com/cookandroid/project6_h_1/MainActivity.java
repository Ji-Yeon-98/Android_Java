package com.cookandroid.project6_h_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Chronometer chronos;
    RadioButton rdoCal, rdoTime;
    TextView tvYear, tvMon, tvDay, tvHour, tvMin;
    TimePicker tPicker;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약(수정)");

        chronos = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMon = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMin = (TextView) findViewById(R.id.tvMinute);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);

        tPicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        chronos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronos.setBase(SystemClock.elapsedRealtime());
                chronos.start();
                chronos.setTextColor(Color.RED);

                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronos.stop();
                chronos.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(datePicker.getYear()));
                tvMon.setText(Integer.toString(datePicker.getMonth()+1));
                tvDay.setText(Integer.toString(datePicker.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMin.setText(Integer.toString(tPicker.getCurrentMinute()));

                tPicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);

            }
        });

    }
}
