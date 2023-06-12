package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a20f0196.R;
import com.example.a20f0196.SQLliteExample.MainActivityContactList;

public class updatedeleteMainActivity extends AppCompatActivity {


    String id;

    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedelete_main);
        database =new database(getApplicationContext());


        Intent intent=getIntent();
        id=intent.getExtras().getString("id");


    }

    public void Delete(View view) {
//        database.deleteContact("3");
//        Toast.makeText(this, "Deletion "+ id, Toast.LENGTH_SHORT).show();
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        deleteBlankFragment deleteBlankFragment=new deleteBlankFragment();
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        deleteBlankFragment.setArguments(bundle);


        fragmentTransaction.replace(R.id.updatedelete,deleteBlankFragment);
        fragmentTransaction.commit();



    }

    public void Update(View view) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        updateBlankFragment updateBlankFragment=new updateBlankFragment();
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        updateBlankFragment.setArguments(bundle);


        fragmentTransaction.replace(R.id.updatedelete,updateBlankFragment);
        fragmentTransaction.commit();
    }
}