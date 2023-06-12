package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.a20f0196.R;

public class adminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);


              FragmentManager fragmentManager= getSupportFragmentManager();
      FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
      allloginBlankFragment allloginBlankFragment=new allloginBlankFragment();
        fragmentTransaction.replace(R.id.admin,allloginBlankFragment);
        fragmentTransaction.commit();

    }
}