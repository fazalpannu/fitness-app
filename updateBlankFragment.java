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
import com.example.a20f0196.SQLliteExample.DbQuerie;

import java.util.HashMap;


public class updateBlankFragment extends Fragment {
    EditText name,age,weight,height,id;
    Button button;
    String position1,position2;
    database database;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_blank, container, false);
        Bundle bundle=getArguments();
        position1=bundle.getString("id");


        database =new database(requireContext());
        button=view.findViewById(R.id.button233);
        id=(EditText)view.findViewById(R.id.id1);
        id.setText(position1);
        name=(EditText)view.findViewById(R.id.namlog1);
        age=(EditText)view.findViewById(R.id.agelog1);
        weight=(EditText)view.findViewById(R.id.weiglog1);
        height=(EditText)view.findViewById(R.id.heiglog1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> contact1=new HashMap<String ,String>();
                contact1.put("Name",name.getText().toString());
                contact1.put("Age",age.getText().toString());
                contact1.put("Weight",weight.getText().toString());
                contact1.put("Height",height.getText().toString());
                position2=id.getText().toString();

                database.updateContact( position2, contact1);
                Toast.makeText(getContext(), "Data Update"+position2, Toast.LENGTH_SHORT).show();

                name.setText("");
                age.setText("");
                weight.setText("");
                height.setText("");
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                allloginBlankFragment allloginBlankFragment=new allloginBlankFragment();
                fragmentTransaction.replace(R.id.updatedelete,allloginBlankFragment);
                fragmentTransaction.commit();
            }

        });

        return view;
    }
}