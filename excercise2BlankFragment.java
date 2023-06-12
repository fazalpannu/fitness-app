package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.util.ArrayList;


public class excercise2BlankFragment extends Fragment {

    GridView gridView;
    ArrayList<String> month=new ArrayList<String>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_excercise2_blank, container, false);
        gridView=view.findViewById(R.id.grid13);
        for (int i = 1; i <= 30; i++) {
            month.add("Day " + i);
        }
        adapter dapter=new adapter(getContext(),month);
        gridView.setAdapter(dapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "positon"+ position, Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                excercise1BlankFragment excercise1BlankFragment=new excercise1BlankFragment();
                fragmentTransaction.replace(R.id.frame,excercise1BlankFragment);
                fragmentTransaction.commit();
            }
        });
   return  view;
    }
}