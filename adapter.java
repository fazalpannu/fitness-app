package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a20f0196.R;

import java.util.ArrayList;

public class adapter extends BaseAdapter {

    Context context;
    ArrayList<String> mon ;

    public adapter(Context context, ArrayList<String> month) {
        this.context = context;
        this.mon = month;
    }

    @Override
    public int getCount() {
        return mon.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View view=             LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter, parent, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView faza=view.findViewById(R.id.day);
        faza.setText(mon.get(position));
        return view;
    }
}
