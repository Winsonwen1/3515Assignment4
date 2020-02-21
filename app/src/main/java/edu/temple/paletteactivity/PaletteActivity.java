package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> list = new ArrayList<>();
        list.add("---Please Choose one of Colour---");
        list.add("WHITE");
        list.add("RED");
        list.add("GREEN");
        list.add("YELLOW");
        list.add("BLUE");
        list.add("GRAY");
        list.add("CYAN");
        list.add("MAGENTA");
        list.add("GREY");
        list.add("LIME");
        list.add("OLIVE");
        list.add("MAROON");

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(list, this));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                } else {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", list.get(position));

                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
