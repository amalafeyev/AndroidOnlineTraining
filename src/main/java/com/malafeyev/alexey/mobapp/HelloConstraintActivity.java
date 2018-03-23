package com.malafeyev.alexey.mobapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloConstraintActivity extends AppCompatActivity {

    private static final String TAG = "HelloConstraintActivity";

    private TextView txvToastConstraint = null;
    private Button btnToastConstraint = null;
    private Button btnCountConstrsint = null;
    private int counter = 0;
    private boolean toogler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_constraint);

        txvToastConstraint = findViewById(R.id.textview_toast_constraint);
        btnToastConstraint = findViewById(R.id.button_toast_constraint);
        btnCountConstrsint = findViewById(R.id.button_count_constraint);
        counter = 0;
        txvToastConstraint.setText(Integer.toString(counter));

    }

    public void onClick(View view) {
        if(view.getId() == btnCountConstrsint.getId()){
            if(txvToastConstraint != null) {
                txvToastConstraint.setText(String.valueOf(++counter));
            }
        }
        else if(view.getId() == btnToastConstraint.getId() || view.getId() == txvToastConstraint.getId()) {
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((View) txvToastConstraint.getParent())
                        .setBackgroundDrawable(getResources()
                                .getDrawable(toogler ? R.drawable.mvimg_20180310_170434 : R.drawable.mvimg_20180311_154941));
            } else {
                ((View) txvToastConstraint.getParent())
                        .setBackground(getResources()
                                .getDrawable(toogler ? R.drawable.mvimg_20180310_170434 : R.drawable.mvimg_20180311_154941));
            }

            toogler = !toogler;
        }

        Toast.makeText(this, "Punch!!!", Toast.LENGTH_SHORT).show();
    }
}
