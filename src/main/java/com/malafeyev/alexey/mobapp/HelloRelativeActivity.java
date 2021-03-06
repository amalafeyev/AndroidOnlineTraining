package com.malafeyev.alexey.mobapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloRelativeActivity extends AppCompatActivity {

    private static final String TAG = "HelloRelativeActivity";

    private TextView txvToastRltv = null;
    private Button btnToastRltv = null;
    private Button btnCountRltv = null;
    private int counter = 0;
    private boolean toogler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_relative);

        txvToastRltv = findViewById(R.id.txvToastRltv);
        btnToastRltv = findViewById(R.id.btnToastRltv);
        btnCountRltv = findViewById(R.id.btnCountRltv);
        counter = 0;
        txvToastRltv.setText(String.valueOf(counter));

    }

    public void onClick(View view) {
        if(view.getId() == btnCountRltv.getId()){
            if(txvToastRltv != null) {
                txvToastRltv.setText(String.valueOf(++counter));
            }
        }
        else if(view.getId() == btnToastRltv.getId() || view.getId() == txvToastRltv.getId()) {
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((View) txvToastRltv.getParent())
                        .setBackgroundDrawable(getResources()
                                .getDrawable(toogler ? R.drawable.mvimg_20180310_170434 : R.drawable.mvimg_20180311_154941));
            } else {
                ((View) txvToastRltv.getParent())
                        .setBackground(getResources()
                                .getDrawable(toogler ? R.drawable.mvimg_20180310_170434 : R.drawable.mvimg_20180311_154941));
            }
            toogler = !toogler;
        }

        Toast.makeText(this, "Punch!!!", Toast.LENGTH_SHORT).show();
    }
}
