package com.malafeyev.alexey.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ShoppingListActivity extends AppCompatActivity {
    public static final String MESSAGE_REPLY =
            GroceryItemsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void returnReply(View view){
        Intent replyIntent = new Intent();
        replyIntent.putExtra(MESSAGE_REPLY, ((Button)view).getText().toString());
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
