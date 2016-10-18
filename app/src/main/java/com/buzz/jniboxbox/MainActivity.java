package com.buzz.jniboxbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/*
Making app to display 5 days of the week, (Mon - Fri)
Convert temperature from Celsius to Fahrenheit for each day
Display TextView of ambient sensor on Top
 */

public class MainActivity extends AppCompatActivity {

    Button conver, ambient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conver = (Button) findViewById(R.id.conversion_btn);
        ambient = (Button) findViewById(R.id.ambient_temp_btn);

        conver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Conversion.class);
                startActivity(intent);
            }
        });

        ambient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ambeint_Temp.class);
                startActivity(intent);
            }
        });

    }

}
