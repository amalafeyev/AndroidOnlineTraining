package com.malafeyev.alexey.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.util.Log.d;

public class BasicActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            BasicActivity.class.getSimpleName();
    private EditText mMessageEditText = null;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    public static final String EXTRA_MESSAGE =
            BasicActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
    }

    //@TargetApi(16)
    public void launchSecondActivity(View view) {
        d(LOG_TAG, "Button Launch BasicActivityReceiver clicked...");
        Intent intent = new Intent(this, BasicReceiverActivity.class);
        String message = "";
        if(view.getId() == R.id.button_main) {
            message = mMessageEditText.getText().toString();
        }
        else if(view.getId() == R.id.button_main_one){
            message = getString(R.string.article_one);
        }
        else if(view.getId() == R.id.button_main_two){
            message = getString(R.string.article_two);
        }
        else if(view.getId() == R.id.button_main_three){
            message = getString(R.string.article_three);
        }
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(BasicReceiverActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}
