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
        Intent intentHelloToast = new Intent(getApplicationContext(), HelloToastActivity.class);
        startActivity(intentHelloToast);
    }

    public void startHelloRelativeActivity(View view) {
        Intent intentHelloRelative = new Intent(getApplicationContext(), HelloRelativeActivity.class);
        startActivity(intentHelloRelative);
    }

    public void startHelloConstraintActivity(View view) {
        Intent intentHelloConstraint = new Intent(getApplicationContext(), HelloConstraintActivity.class);
        startActivity(intentHelloConstraint);
    }

    public void startScrollingTextActivity(View view) {
        Intent intentScrollingText = new Intent(getApplicationContext(), ScrollingTextActivity.class);
        startActivity(intentScrollingText);
    }

    public void startBasicActivity(View view) {
        Intent intentBasicActivity = new Intent(getApplicationContext(), BasicActivity.class);
        startActivity(intentBasicActivity);
    }

    public void startCalculatorActivity(View view) {
        Intent intentCalculatorActivity = new Intent(getApplicationContext(), CalculatorActivity.class);
        startActivity(intentCalculatorActivity);
    }

    public void startSupportLibraryActivity(View view) {
        Intent intentSupportLibraryActivity = new Intent(getApplicationContext(), SupportLibraryActivity.class);
        startActivity(intentSupportLibraryActivity);
    }

    public void startKeyboardSamplesActivity(View view) {
        Intent intentKeyboardSamplesActivity = new Intent(getApplicationContext(), KeyboardSamplesActivity.class);
        startActivity(intentKeyboardSamplesActivity);
    }
}
