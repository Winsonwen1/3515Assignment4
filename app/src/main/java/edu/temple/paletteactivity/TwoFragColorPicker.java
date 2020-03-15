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

public class TwoFragColorPicker extends AppCompatActivity implements PaletteFragment.ButtonClickedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getResources();

        String[] gridLabels = res.getStringArray(R.array.my_array);
        String[] colorsStr = res.getStringArray(R.array.colors);

         ArrayList<String> list = new ArrayList<>();
         ArrayList<String> colors = new ArrayList<>();

        Collections.addAll(list, gridLabels);
        Collections.addAll(colors, colorsStr);

        PaletteFragment paletteFragment = PaletteFragment.newInstance(list, colors);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,paletteFragment)
                .commit();

    }

    @Override
    public void buttonClicked(String colors, String  colorName) {

        CanvasFragment canvasFragment1 = CanvasFragment.newInstance(colors,colorName );
//
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container2,canvasFragment1)
                .addToBackStack(null)
                .commit();
    }
}
