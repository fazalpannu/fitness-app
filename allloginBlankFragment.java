package com.example.a20f0196.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20f0196.R;
import com.example.a20f0196.SQLliteExample.DbQuerie;

import java.util.ArrayList;
import java.util.HashMap;


public class allloginBlankFragment extends Fragment {
database database;
RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_alllogin_blank, container, false);
recyclerView=view.findViewById(R.id.rcyclerlogin);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        database =new database(requireContext());
        ArrayList<HashMap<String,String>> ContactList= database.getContactlist();
        diet3 dietAdapter = new diet3(ContactList,  getContext());


        recyclerView.setAdapter(dietAdapter);
        return view;

    }
}