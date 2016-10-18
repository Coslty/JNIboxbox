package com.buzz.jniboxbox;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Conversion extends Activity{

    TextView mondayfrh, tuesdayfrh, wednesdayfrh, thursdayfrh, fridayfrh;
    TextView mondaycels, tuesdaycels, wednesdaycels, thursdaycels, fridaycels;
    TextView ambient_temp;
    Switch switch_mon,switch_tues,switch_wed,switch_thurs,switch_fri;
    Button random_temp;

    int cels_monday, cels_tuesday, cels_wedensday, cels_thursday, cels_friday;
    public boolean isTrue = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_temp);

        mondayfrh = (TextView) findViewById(R.id.mondayfrh);
        tuesdayfrh = (TextView) findViewById(R.id.tuesdayfrh);
        wednesdayfrh = (TextView) findViewById(R.id.wednesdayfrh);
        thursdayfrh = (TextView) findViewById(R.id.thuesdayfrh);
        fridayfrh = (TextView) findViewById(R.id.fridayfrh);

        mondaycels = (TextView) findViewById(R.id.mondaycels);
        tuesdaycels = (TextView) findViewById(R.id.tuesdaycels);
        wednesdaycels = (TextView) findViewById(R.id.wednesdaycels);
        thursdaycels = (TextView) findViewById(R.id.thuesdaycels);
        fridaycels = (TextView) findViewById(R.id.fridaycels);

        switch_mon = (Switch) findViewById(R.id.switchmonday);
        switch_tues = (Switch) findViewById(R.id.switchtuesday);
        switch_wed = (Switch) findViewById(R.id.switchwednesday);
        switch_thurs = (Switch) findViewById(R.id.switchthursday);
        switch_fri = (Switch) findViewById(R.id.switchfriday);

        ambient_temp = (TextView) findViewById(R.id.ambient_temperature);

        random_temp = (Button) findViewById(R.id.button_random_gen);


        //On the starting app, generate a random number for Mon - Fri in Celsius
        cels_monday = randomGen();
        cels_tuesday = randomGen();
        cels_wedensday = randomGen();
        cels_thursday = randomGen();
        cels_friday = randomGen();

        //Set numbers in TextView for every days (Mon - Fri)
        mondaycels.setText(Integer.toString(cels_monday));
        tuesdaycels.setText(Integer.toString(cels_tuesday));
        wednesdaycels.setText(Integer.toString(cels_wedensday));
        thursdaycels.setText(Integer.toString(cels_thursday));
        fridaycels.setText(Integer.toString(cels_friday));


        //Button click to generate another random numbers than reset the TextView for each days
        random_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrue = true;
                cels_monday = randomGen();
                cels_tuesday = randomGen();
                cels_wedensday = randomGen();
                cels_thursday = randomGen();
                cels_friday = randomGen();

                mondaycels.setText(Integer.toString(cels_monday));
                tuesdaycels.setText(Integer.toString(cels_tuesday));
                wednesdaycels.setText(Integer.toString(cels_wedensday));
                thursdaycels.setText(Integer.toString(cels_thursday));
                fridaycels.setText(Integer.toString(cels_friday));

                switch_mon.setChecked(false);
                switch_tues.setChecked(false);
                switch_wed.setChecked(false);
                switch_thurs.setChecked(false);
                switch_fri.setChecked(false);
            }
        });


        //5 Switches
        //Do convert from Celsius to Fahrenheit
        //From Fahrenheit to Celsius
        switch_mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    double d = (double) cels_monday;
                    mondayfrh.setVisibility(View.VISIBLE);
                    mondaycels.setVisibility(View.INVISIBLE);
                    mondayfrh.setText(Double.toString(Converter(d)));

                } else {
                    mondaycels.setVisibility(View.VISIBLE);
                    mondayfrh.setVisibility(View.INVISIBLE);
                    System.out.println("Left");
                }
            }
        });

        switch_tues.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    double d = (double) cels_tuesday;
                    tuesdayfrh.setVisibility(View.VISIBLE);
                    tuesdaycels.setVisibility(View.INVISIBLE);
                    tuesdayfrh.setText(Double.toString(Converter(d)));

                } else {
                    tuesdaycels.setVisibility(View.VISIBLE);
                    tuesdayfrh.setVisibility(View.INVISIBLE);
                    System.out.println("Left");
                }
            }
        });

        switch_wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wednesdaycels.setVisibility(View.INVISIBLE);
                    double d = (double)cels_wedensday;
                    wednesdayfrh.setVisibility(View.VISIBLE);
                    wednesdayfrh.setText(Double.toString(Converter(d)));

                } else {
                    wednesdaycels.setVisibility(View.VISIBLE);
                    wednesdayfrh.setVisibility(View.INVISIBLE);
                }
            }
        });

        switch_thurs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    thursdaycels.setVisibility(View.INVISIBLE);
                    double d = (double) cels_thursday;
                    thursdayfrh.setVisibility(View.VISIBLE);
                    thursdayfrh.setText(Double.toString(Converter(d)));

                } else {
                    thursdaycels.setVisibility(View.VISIBLE);
                    thursdayfrh.setVisibility(View.INVISIBLE);
                }
            }
        });

        switch_fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fridaycels.setVisibility(View.INVISIBLE);
                    double d = (double) cels_friday;
                    fridayfrh.setVisibility(View.VISIBLE);
                    fridayfrh.setText(Double.toString(Converter(d)));

                } else {
                    fridaycels.setVisibility(View.VISIBLE);
                    fridayfrh.setVisibility(View.INVISIBLE);
                    System.out.println("Left");
                }
            }
        });

    }
    //Random number set range 21 to 37 in Celsius (Since it is appropriate temperature
    int randomGen (){
        int range = 16;
        return (int)(Math.random() * range) + 21;
    }

    //Use JNI function
    //Called C method named "Converter"
    public  native double Converter(double x);
    static {
        System.loadLibrary("ndktest");
    }

}
