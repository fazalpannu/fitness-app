package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.a20f0196.R;

public class loginstartMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginstart_main);




                FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        lstBlankFragment lstBlankFragment=new lstBlankFragment();
        fragmentTransaction.replace(R.id.startlogin,lstBlankFragment);
        fragmentTransaction.commit();
    }
}