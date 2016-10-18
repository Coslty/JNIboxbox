package com.buzz.jniboxbox;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Ambeint_Temp extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;

    TextView ambient_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambient_temp);
        ambient_number = (TextView) findViewById(R.id.ambient_temperature);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float ambient_temperature = event.values[0];
        ambient_number.setText(Float.toString(ambient_temperature));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
         sensorManager.registerListener(this,
                 sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
         SensorManager.SENSOR_DELAY_NORMAL);
    }



    @Override
    protected void onPause() {
        super.onPause();
         sensorManager.unregisterListener(this);
    }
}





