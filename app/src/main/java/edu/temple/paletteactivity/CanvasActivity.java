package edu.temple.paletteactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_activity);

        Intent intent = getIntent();

        String colorName = intent.getStringExtra("colorName");
        String color = intent.getStringExtra("color");

        ConstraintLayout cl =  findViewById(R.id.Layout);

        ((TextView)findViewById(R.id.textView)).setText(colorName);
        cl.setBackgroundColor(Color.parseColor(color));


    }
}
