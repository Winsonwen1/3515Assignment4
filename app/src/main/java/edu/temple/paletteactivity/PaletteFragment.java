package edu.temple.paletteactivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class PaletteFragment extends Fragment {

    ButtonClickedInterface parentActivity;

    View layout;

    ArrayList<String> colorName;
    ArrayList<String> colors;

    public static PaletteFragment newInstance (ArrayList<String> list, ArrayList<String> colors) {
        PaletteFragment fragment = new PaletteFragment();

        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("colorName", list);
        bundle2.putStringArrayList("colors", colors);
        fragment.setArguments(bundle2);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            colors = bundle.getStringArrayList("colors");
            colorName = bundle.getStringArrayList("colorName");
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ButtonClickedInterface) {
            parentActivity = (ButtonClickedInterface) context;
        } else {
            throw new RuntimeException("Please Implement the ButtonClickedListener Interface!!!!!!!");
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.palette_fragment, container, false);

        Spinner spinner = layout.findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(colors, colorName,this.getContext()));


        ((Spinner)layout.findViewById(R.id.spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // do nothing
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("colors", colors.get(position));
                    bundle2.putString("colorName", colorName.get(position));
                    parentActivity.buttonClicked(colors.get(position), colorName.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        return layout;
    }

    interface ButtonClickedInterface {
        public void buttonClicked(String colors, String  colorName);
    }
}
