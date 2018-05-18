package com.malafeyev.alexey.mobapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KeyboardSamplesActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private static final String TAG = KeyboardSamplesActivity.class.getSimpleName();
    private EditText editTextMessage;
    private String mSpinnerLabel = "";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_samples);

        editTextMessage = (EditText) findViewById(R.id.edit_text_keyboard_one);
        editText = (EditText) findViewById(R.id.editText_main);

        // Create the spinner.
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        EditText editText = (EditText) findViewById(R.id.edit_text_keyboard_five);
        if (editText != null)
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                    boolean mHandled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        mHandled = true;
                    }
                    return mHandled;
                }
            });
    }

    private void dialNumber() {
        EditText editText = (EditText) findViewById(R.id.edit_text_keyboard_five);
        String mPhoneNum = null;
        if (editText != null) mPhoneNum = "tel:" + editText.getText().toString();
        Log.d(TAG, "dialNumber: " + mPhoneNum);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(mPhoneNum));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void showToastedMessage(View view) {
        if (editTextMessage != null) {
            Toast.makeText(this, editTextMessage.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        if (editText != null) {
            // Assign to showString both the entered string and mSpinnerLabel.
            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            // Assign to phoneNumberResult the view for text_phonelabel to prepare to show it.
            TextView phoneNumberResult = (TextView) findViewById(R.id.text_phonelabel);
            // Show the showString in the phoneNumberResult.
            if (phoneNumberResult != null) phoneNumberResult.setText(showString);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected: ");
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(KeyboardSamplesActivity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle(R.string.alert_title);
        // Set the dialog message.
        myAlertBuilder.setMessage(R.string.alert_message);
        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                Toast.makeText(getApplicationContext(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();
            }
        });

        myAlertBuilder.setNegativeButton(R.string.cancel, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), R.string.pressed_cancel,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // Create and show the AlertDialog.
        myAlertBuilder.show();
    }

    public void onClickShowDateTimePickersActivity(View view) {
        Intent intentDatePickers = new Intent(getApplicationContext(), DateTimePickersActivity.class);
        startActivity(intentDatePickers);
    }


    public void onClickShowImagesActivity(View view) {
        Intent intentImageClick = new Intent(getApplicationContext(), ImageClickActivity.class);
        startActivity(intentImageClick);
    }
}
