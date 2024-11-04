package com.example.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager mSersorManeger;
    Sensor mSensor;
    TextView textView, textView1, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);


        mSersorManeger= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor=mSersorManeger.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSersorManeger.registerListener((SensorEventListener) this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Oq fzr qnd um evento de sensor é detectado
        textView.setText("X: "+String.valueOf(event.values[0]));
        textView1.setText("Y: "+String.valueOf(event.values[1]));
        textView2.setText("Z: "+String.valueOf(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}