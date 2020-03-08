package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getResources();
        String[] gridLabels = res.getStringArray(R.array.my_array);
        String[] colorsStr = res.getStringArray(R.array.colors);
        final ArrayList<String> list = new ArrayList<>();
        final ArrayList<String> colors = new ArrayList<>();

        Collections.addAll(list, gridLabels);
        Collections.addAll(colors, colorsStr);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(colors, list, this));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // do nothing
                } else {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("colorName", list.get(position));
                    intent.putExtra("color", colors.get(position));
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
