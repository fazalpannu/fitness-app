package com.example.a20f0196.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20f0196.R;

public class stepsensorMainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textView1, textView2;

    private SensorManager sensorManager;
    private Sensor stepDetector;
    private int stepCount = 0;

    private boolean isDetectorPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepsensor_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textView2=findViewById(R.id.textView12);
        textView1 = findViewById(R.id.step);
        Intent intent=getIntent();
        Integer position = (intent.getIntExtra("position",0));

//        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();

if (position==0)
{
    textView2.setText("3000 steps Walk before Breakfast");
    textView2.setTextColor(Color.BLUE);
    getWindow().getDecorView().setBackgroundResource(R.drawable.wlkf);

//    View rootView = findViewById(android.R.id.content).getRootView();
//    rootView.setBackgroundResource(R.drawable.walkf); // Set the background resource

} else if (position==1) {
    textView2.setText("1000 steps Climb the stair after Lunch");
    getWindow().getDecorView().setBackgroundResource(R.drawable.stairf);
//    View rootView = findViewById(android.R.id.content).getRootView();
//    rootView.setBackgroundResource(R.drawable.stairf); // Set the background resource

}
else {
    textView2.setText("5000 steps Running after Dinner");
    getWindow().getDecorView().setBackgroundResource(R.drawable.dinnerf);
//    View rootView = findViewById(android.R.id.content).getRootView();
//    rootView.setBackgroundResource(R.drawable.dinnerf); // Set the background resource

}

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            stepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

            isDetectorPresent = true;
        } else {
            textView1.setText("Detector not present");
            isDetectorPresent = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "before register", Toast.LENGTH_SHORT).show();
        if (isDetectorPresent) {
            sensorManager.registerListener(this, stepDetector, SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isDetectorPresent) {
            sensorManager.unregisterListener(this, stepDetector);
            Toast.makeText(this, "unregister", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Toast.makeText(this, "change", Toast.LENGTH_SHORT).show();
        if (event.sensor == stepDetector) {
            // Check for noisy data
            if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
                return;
            }
            // Filter out small changes in data
            if (event.values[0] < 1) {
                return;
            }
            else {
            stepCount++;
            textView1.setText(String.valueOf(stepCount));
        }}
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle changes in sensor accuracy
        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            switch (accuracy) {
                case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                case SensorManager.SENSOR_STATUS_UNRELIABLE:
                    // Stop using this sensor if the accuracy is low or unreliable
                    sensorManager.unregisterListener(this, sensor);
                    isDetectorPresent = false;
                    textView1.setText("Detector not accurate");
                    break;
            }
        }
    }
}
