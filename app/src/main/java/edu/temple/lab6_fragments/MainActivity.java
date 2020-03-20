package edu.temple.lab6_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int clicked = 0;
    Spinner spinner;
    RelativeLayout myLayout;

    public static String[] colors = new String[] {"red", "blue", "green", "yellow", "gray", "cyan", "magenta", "black", "lightGray", "white"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        myLayout = findViewById(R.id.myLayout);

        final ColorAdapter adapter = new ColorAdapter(getApplicationContext(), colors);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(clicked != 0) {
                    Toast.makeText(getApplicationContext(), "some message", Toast.LENGTH_SHORT).show();

                    CanvasFragment cFrag = new CanvasFragment();

                    Bundle bundle = new Bundle();
                    bundle.putString("selectedColor", colors[position]);
                    cFrag.setArguments(bundle);


                    // Add Canvas Fragment to its container
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction().add(R.id.canvas_container, cFrag);
                    ft.addToBackStack(null);

                    // Get change background color


                    // Make canvas fragment fill screen
//                    FrameLayout canvas = findViewById(R.id.canvas_layout);
//                    ViewGroup.LayoutParams params = canvas.getLayoutParams();
//                    params.height = params.FILL_PARENT;
//                    params.width = params.FILL_PARENT;
//
//                    FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) canvas.getLayoutParams();
//                    lp.height = FrameLayout.LayoutParams.FILL_PARENT;
//                    canvas.setLayoutParams(lp);

                    ft.commit();
                }
                clicked++;
            }

            @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                //your code here
             }


        });
    }
}
