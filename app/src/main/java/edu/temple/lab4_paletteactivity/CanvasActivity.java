package edu.temple.lab4_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

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
        String color = intent.getStringExtra("selectedColor");

        // Set background and textView according to intent data
        layout.setBackgroundColor(Color.parseColor(color));
        txt.setText(color);
    }
}
