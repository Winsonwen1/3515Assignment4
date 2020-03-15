package edu.temple.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class CanvasFragment extends Fragment {

    View layout;
    private static final String COLORS = "colors";
    private static final String COLOR_NAME = "colorName";

    public static CanvasFragment newInstance (String colors, String  colorName) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString(COLORS, colors);
        bundle.putString(COLOR_NAME, colorName);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.canvas_fragment, container, false);
        //((TextView)layout.findViewById(R.id.textView)).setText(getArguments().getString(COLOR_NAME));
        layout.setBackgroundColor(Color.parseColor(getArguments().getString(COLORS)));

        return layout;
    }






}
