package edu.temple.lab6_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    PaletteFragment pFrag;
    CanvasFragment cFrag;

    public static String[] colors = new String[] {"red", "blue", "green", "yellow", "gray", "cyan", "magenta", "black", "lightGray", "white"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        pFrag = new PaletteFragment();
        cFrag = new CanvasFragment();


        ColorAdapter adapter = new ColorAdapter(getApplicationContext(), colors);
        spinner.setAdapter(adapter);
    }
}
