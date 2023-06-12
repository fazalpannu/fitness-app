package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.a20f0196.R;

import java.util.ArrayList;

public class dietplan2MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<String> main=new ArrayList<String>();
    ArrayList<String> sub=new ArrayList<String>();
    ArrayList<Integer> img1=new ArrayList<Integer>();
    ArrayList<Integer> img2=new ArrayList<Integer>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan2_main);
        recyclerView=findViewById(R.id.recycler12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
//        String weight = sharedPreferences.getString("weight", "");
//        String temperature = sharedPreferences.getString("temperature", "");
//        String bloodPressure = sharedPreferences.getString("bloodPressure", "");
//        String symptoms = sharedPreferences.getString("symptoms", "");

        main.add("Break Fast");
        main.add("Sun Raisng");
        main.add("Launch");
        main.add("Sun in West");
        main.add("Dinner");

        sub.add("1 serving Avocade-Egg Toast (calories 271)");
        sub.add("1 medium orange (calories 62)   ");
        sub.add("1 serving Butternut Squash Soup with Avocado and Chickpeas (calories 402)");
        sub.add("1 medium kiwi (calories 42)      ");
        sub.add("1 serving Citrus poached Salmon with Asparagus with 3 by 4 cup Cauliflower Rice (calories 451)");

        img1.add(R.drawable.img_4);
        img1.add(R.drawable.am);
        img1.add(R.drawable.lunch);
        img1.add(R.drawable.pm);
        img1.add(R.drawable.dinner);

        img2.add(R.drawable.arrow);
        img2.add(R.drawable.arrow);
        img2.add(R.drawable.arrow);
        img2.add(R.drawable.arrow);
        img2.add(R.drawable.arrow);
        diet1 dietAdapter = new diet1(main,sub,  img1,img2 , this);
        recyclerView.setAdapter(dietAdapter);
    }
}