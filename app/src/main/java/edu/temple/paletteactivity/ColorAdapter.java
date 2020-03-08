package edu.temple.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter {
    private ArrayList<String> color;
    private ArrayList<String> list;
    private  Context context;

    ColorAdapter(ArrayList<String> color, ArrayList<String> list, Context context) {
        this.color = color;
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return color.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView(context.getApplicationContext());
        tv.setText(list.get(position));
        tv.setId(position);
        if (position != 0) {
            tv.setBackgroundColor(Color.parseColor(color.get(position)));
        }

        return tv;
    }
}

