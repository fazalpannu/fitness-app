package com.example.a20f0196.project;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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

import java.util.HashMap;


public class loginBlankFragment extends Fragment {


    Button button;
    EditText name,age,weight,height;
    database database;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "my_channel";
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login_blank, container, false);

        database =new database(requireContext());
        button=view.findViewById(R.id.button233);
        name=(EditText)view.findViewById(R.id.namlog1);
        age=(EditText)view.findViewById(R.id.agelog1);
        weight=(EditText)view.findViewById(R.id.weiglog1);
        height=(EditText)view.findViewById(R.id.heiglog1);
        createNotificationChannel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> contact1=new HashMap<String ,String>();
                contact1.put("Name",name.getText().toString());
                contact1.put("Age",age.getText().toString());
                contact1.put("Weight",weight.getText().toString());
                contact1.put("Height",height.getText().toString());

        database.InsertSingleContact(contact1);
                Toast.makeText(getContext(), "Data Added", Toast.LENGTH_SHORT).show();

                name.setText("");
                age.setText("");
                weight.setText("");
                height.setText("");

                showNotification();
                Intent intent=new Intent(getContext(),firstloginMainActivity.class);
                startActivity(intent);

//                FragmentManager fragmentManager= getParentFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                lstBlankFragment lstBlankFragment=new lstBlankFragment();
//                fragmentTransaction.replace(R.id.start,lstBlankFragment);
//                fragmentTransaction.commit();
            }
        });


        return  view;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = requireActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @SuppressLint("MissingPermission")
    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.fitness)
                .setContentTitle("Fitness Plan")
                .setContentText("30 Days Diet Plan has been register")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}