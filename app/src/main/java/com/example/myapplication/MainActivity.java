package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button ;
    ProgressBar progressBar;
    Handler handler;

    Spinner spinner;
    SeekBar seekBar;

    String [] arr= {"ali","nak", "jan", "show"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById( R.id.spinner);
        seekBar = findViewById( R.id.seekBar);
        textView = findViewById(R.id.textView);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress=0;
            @Override
            public void onProgressChanged(SeekBar bar, int progressvalue, boolean fromUser) {
             progress = progressvalue;

                bar.setProgress(progress);
                textView.setText("Covered:" + seekBar.getProgress() + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(),"change seekbar progress"+progress ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            Toast.makeText(getApplicationContext(),"Start tracking seekbar ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"stoped traking seekbar",Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter arrayAdapter =new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item ,arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arr[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }


        });


    }
}