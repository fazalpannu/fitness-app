package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.a20f0196.R;
import com.example.a20f0196.firebaseactivity.anecgpaBlankFragment;

public class exerciseplan1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciseplan1_main);
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        excercise2BlankFragment excercise2BlankFragment=new excercise2BlankFragment();
        fragmentTransaction.replace(R.id.frame,excercise2BlankFragment);
        fragmentTransaction.commit();


    }
}