package com.example.chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    boolean  running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txt1 = (TextView) findViewById(R.id.text);
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.chronometer1);
        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);
        Button reset = (Button) findViewById(R.id.reset);

        //For start
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!running){
                    simpleChronometer.setBase(SystemClock.elapsedRealtime());
                    simpleChronometer.start();
                    running = true;
                }
                simpleChronometer.start();
            }
        });

        //For Stop
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    simpleChronometer.stop();
                    running = false;

                    long elapsedMillis = SystemClock.elapsedRealtime() - simpleChronometer.getBase();

                    //For changing text in textview
                    txt1.setText("Elapsed milliseconds: " + elapsedMillis);

                }
            }
        });

        //For reset time
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }
}