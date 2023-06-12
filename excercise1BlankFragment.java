package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.a20f0196.R;

import java.util.ArrayList;


public class excercise1BlankFragment extends Fragment  {

    RecyclerView recyclerView;
    ArrayList<String> main=new ArrayList<String>();

    ArrayList<Integer> img1=new ArrayList<Integer>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_excercise1_blank, container, false);
        recyclerView=view.findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        main.add(" Before breakfast");
        main.add(" After lunch");
        main.add("  After Dinner");


        img1.add(R.drawable.walk);
        img1.add(R.drawable.stear);
        img1.add(R.drawable.running);

        diet2 dietAdapter = new diet2(main,  img1,  getContext());
        recyclerView.setAdapter(dietAdapter);




    return  view;
    }


}