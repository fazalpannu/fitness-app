package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20f0196.R;

public class useradminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useradmin_main);
    }

    public void user(View view) {

        Intent intent=new Intent(this,startapp.class);
        startActivity(intent);
    }

    public void admin(View view) {

        Intent intent=new Intent(this,adminMainActivity.class);
        startActivity(intent);
    }
}