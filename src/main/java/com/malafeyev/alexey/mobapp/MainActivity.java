package com.malafeyev.alexey.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            float d = 1;
//        } catch (Exception ex) {
//            Log.d(TAG, "Hello World", ex);
//        }
    }

    public void startHelloToastActivity(View view) {
        Intent intentHelloToast = new Intent(getApplicationContext(), HelloToastClassActivity.class);
        startActivity(intentHelloToast);
    }

    public void startHelloRelativeActivity(View view) {
        Intent intentHelloRelative = new Intent(getApplicationContext(), HelloRelative.class);
        startActivity(intentHelloRelative);
    }
}
