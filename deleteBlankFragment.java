package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.util.HashMap;


public class deleteBlankFragment extends Fragment {

    EditText id;
    Button button;
    String position1,position2;
    database database;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_blank, container, false);
        Bundle bundle=getArguments();
        position1=bundle.getString("id");
        database =new database(requireContext());
        button=view.findViewById(R.id.btndelete1);
        id=(EditText)view.findViewById(R.id.txtdelete);
        id.setText(position1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position2=id.getText().toString();

                database.deleteContact(position2);
                Toast.makeText(getContext(), "Data Delte"+position2, Toast.LENGTH_SHORT).show();

                id.setText("");

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                allloginBlankFragment allloginBlankFragment=new allloginBlankFragment();
                fragmentTransaction.replace(R.id.updatedelete,allloginBlankFragment);
                fragmentTransaction.commit();
            }

        });


        return  view;
    }
}