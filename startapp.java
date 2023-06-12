package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.example.a20f0196.R;

import java.util.Calendar;

public class startapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startapp);

//        FragmentManager fragmentManager= getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        lstBlankFragment lstBlankFragment=new lstBlankFragment();
//        fragmentTransaction.replace(R.id.start,lstBlankFragment);
//        fragmentTransaction.commit();



        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        loginBlankFragment loginBlankFragment=new loginBlankFragment();
        fragmentTransaction.replace(R.id.start,loginBlankFragment);
        fragmentTransaction.commit();


        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,21);
        calendar.set(Calendar.MINUTE,40);
        calendar.set(Calendar.SECOND,0);
        Intent intent=new Intent(getApplicationContext(),Notification_Reciever.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);




//      FragmentManager fragmentManager= getSupportFragmentManager();
//      FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//      allloginBlankFragment allloginBlankFragment=new allloginBlankFragment();
//        fragmentTransaction.replace(R.id.start,allloginBlankFragment);
//        fragmentTransaction.commit();

    }
}