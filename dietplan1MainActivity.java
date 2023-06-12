package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.Calendar;

public class dietplan1MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<String> month=new ArrayList<String>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan1_main);
        gridView=findViewById(R.id.gridview32);
        for (int i = 1; i <= 30; i++) {
            month.add("Day " + i);
        }




        adapter dapter=new adapter(this,month);
        gridView.setAdapter(dapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(dietplan1MainActivity.this, "positon"+ position, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(dietplan1MainActivity.this,dietplan2MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void filllist() {




    }
}