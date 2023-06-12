package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a20f0196.R;
import com.example.a20f0196.SQLliteExample.DbQuerie;

import java.util.HashMap;

public class firstloginMainActivity extends AppCompatActivity {
    database database;
    EditText id;
    String id1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlogin_main);
        database=new database(getApplicationContext());
        id=(EditText) findViewById(R.id.firstlogin);


//        HashMap<String,String> singleContact= dbQuerie.getSingleContact(id);
//
//
    }

    public void login(View view) {


        id1 =  id.getText().toString();
        if (id1.isEmpty() ) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
        Toast.makeText(this, "ID "+id1, Toast.LENGTH_SHORT).show();
    HashMap<String,String> singleContact= database.getSingleContact(id1);
    if(singleContact.size()>0)
    {
        Intent intent=new Intent(this,loginstartMainActivity.class);
        startActivity(intent);
//
    }
    else {
        Toast.makeText(this, "ID "+id1+" not found", Toast.LENGTH_SHORT).show();
    }
}}}