package com.example.midtermscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

enum Points {
    PAT(1),
    SAFETY(2),
    FG(3),
    TD(6);

    private int points;

    Points(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

public class MainActivity extends AppCompatActivity {


    Button aMinus, aPlus, bMinus, bPlus;
    Spinner spinner;
    TextView aScore, bScore;
    Points points = Points.TD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aMinus = findViewById(R.id.aMinus);
        aPlus = findViewById(R.id.aPlus);
        bMinus = findViewById(R.id.bMinus);
        bPlus = findViewById(R.id.bPlus);

        spinner = findViewById(R.id.spinner);

        aScore = findViewById(R.id.aScore);
        bScore = findViewById(R.id.bScore);

        List<Points> list = Arrays.asList(Points.values());
        ArrayAdapter<Points> adapter = new ArrayAdapter<Points>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                points = Points.values()[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        aMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore.setText(String.valueOf(Integer.parseInt(aScore.getText().toString()) - points.getPoints()));
            }
        });
        aPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore.setText(String.valueOf(Integer.parseInt(aScore.getText().toString()) + points.getPoints()));
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bScore.setText(String.valueOf(Integer.parseInt(bScore.getText().toString()) - points.getPoints()));
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bScore.setText(String.valueOf(Integer.parseInt(bScore.getText().toString()) + points.getPoints()));
            }
        });
    }
}