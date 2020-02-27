package edu.temple.lab4_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.res.Resources;

import java.util.jar.Attributes;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout layout;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");

        layout = findViewById(R.id.canvasLayout);
        txt = findViewById(R.id.textViewCanvas);


        // Retrieve intent data
        Intent intent = getIntent();
        int colorLocation = intent.getIntExtra("selectedColor", 0);

        // Retrieve a string-array resource
        Resources res = getResources();
        String[] resColorArray = res.getStringArray(R.array.color_string_array);

        // Set background and textView according to intent data
        layout.setBackgroundColor(Color.parseColor(MainActivity.colors[colorLocation]));

        txt.setText(resColorArray[colorLocation]);
    }
}
