package edu.temple.lab4_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    public static ConstraintLayout myLayout;
    Spinner spinner;

    String[] colors = new String[] {"red", "blue", "green", "yellow", "gray", "cyan", "magenta", "black", "lightGray", "white"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.myLayout);
        spinner = findViewById(R.id.spinner);
        ColorAdapter adapter = new ColorAdapter(getApplicationContext(), colors);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myLayout.setBackgroundColor(Color.parseColor(colors[position]));

                view.setBackgroundColor(Color.WHITE);

                // Open Activity 2
                if (count > 0) {
                    Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
                    intent.putExtra("selectedColor", colors[position]);
                    startActivity(intent);
                }
                count++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
}
