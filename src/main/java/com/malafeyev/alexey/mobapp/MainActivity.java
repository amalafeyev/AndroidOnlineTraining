package com.malafeyev.alexey.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView txvToast = null;
    private Button btnToast = null;
    private Button btnCount = null;
    private int counter = 0;
    private boolean toogler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvToast = (TextView) findViewById(R.id.txvToast);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnCount = (Button) findViewById(R.id.btnCount);
        counter = 0;
        txvToast.setText(String.valueOf(counter));

//        try {
//            float d = 1;
//        } catch (Exception ex) {
//            Log.d(TAG, "Hello World", ex);
//        }

        btnCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnCount.getId()){
            if(txvToast != null) {
                txvToast.setText(String.valueOf(++counter));
            }
        }
        else if(view.getId() == btnToast.getId() || view.getId() == txvToast.getId()){
            ((View)txvToast.getParent())
                    .setBackground(getDrawable(
                            toogler ? R.drawable.mvimg_20180310_170434 : R.drawable.mvimg_20180311_154941));
            toogler = !toogler;
        }

        Toast.makeText(this, "Punch!!!", Toast.LENGTH_SHORT).show();
    }

    public void startHelloRelativeActivity(View view) {
        Intent intentHelloRelative = new Intent(getApplicationContext(), HelloRelative.class);
        startActivity(intentHelloRelative);
    }
}
