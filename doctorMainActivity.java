package com.example.a20f0196.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.a20f0196.R;

public class doctorMainActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;

    private EditText weightEditText, temperatureEditText, bloodPressureEditText, symptomsEditText;
    private Button submitButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        weightEditText = findViewById(R.id.weightEditText);
        temperatureEditText = findViewById(R.id.temperatureEditText);
        bloodPressureEditText = findViewById(R.id.bloodPressureEditText);
        symptomsEditText = findViewById(R.id.symptomsEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectData();
            }
        });
    }



    private void collectData() {
        String weight = weightEditText.getText().toString();
        String temperature = temperatureEditText.getText().toString();
        String bloodPressure = bloodPressureEditText.getText().toString();
        String symptoms = symptomsEditText.getText().toString();

        // Check if the required fields are filled
        if (weight.isEmpty() || temperature.isEmpty() || bloodPressure.isEmpty() || symptoms.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Collect the user's location


        // Save the collected data using SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("weight", weight);
        editor.putString("temperature", temperature);
        editor.putString("bloodPressure", bloodPressure);
        editor.putString("symptoms", symptoms);
        editor.apply();

        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }


}
