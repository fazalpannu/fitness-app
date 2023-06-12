package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.a20f0196.R;


public class lstBlankFragment extends Fragment {

   ImageButton button1,button2,button3;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_lst_blank, container, false);
       button1=view.findViewById(R.id.nearbygym);
       button2=view.findViewById(R.id.diet);
       button3=view.findViewById(R.id.exercise);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent=new Intent(getContext(),mapMainActivity.class);
               startActivity(intent);
           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(),dietplan1MainActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(),exerciseplan1MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}