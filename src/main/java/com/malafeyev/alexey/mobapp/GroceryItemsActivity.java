package com.malafeyev.alexey.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GroceryItemsActivity extends AppCompatActivity {

    private int shopping_list_index = 0;
    public static final int REQUEST_GROCERY_ITEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_items);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_grocery);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // run the grocery item chooser activity
                Intent intent = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivityForResult(intent, REQUEST_GROCERY_ITEM);
                shopping_list_index++;
                if (shopping_list_index > 10)
                    shopping_list_index = 1;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_GROCERY_ITEM) {
            if (resultCode == RESULT_OK) {
                findNextTextView(shopping_list_index).setText(
                        data.getStringExtra(ShoppingListActivity.MESSAGE_REPLY));
            }
        }
    }

    private TextView findNextTextView(int index) {
        switch (index) {
            case 1:
                return findViewById(R.id.text_view_1);
            case 2:
                return findViewById(R.id.text_view_2);
            case 3:
                return findViewById(R.id.text_view_3);
            case 4:
                return findViewById(R.id.text_view_4);
            case 5:
                return findViewById(R.id.text_view_5);
            case 6:
                return findViewById(R.id.text_view_6);
            case 7:
                return findViewById(R.id.text_view_7);
            case 8:
                return findViewById(R.id.text_view_8);
            case 9:
                return findViewById(R.id.text_view_9);
            case 10:
                return findViewById(R.id.text_view_10);
        }
        return null;
    }
}

