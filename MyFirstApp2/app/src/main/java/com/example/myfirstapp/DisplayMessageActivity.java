package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("intent", "Received intent with John 3:16");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the strings
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(MainActivity.BOOK);
        String message2 = intent.getStringExtra(MainActivity.CHAPTER);
        String message3 = intent.getStringExtra(MainActivity.VERSE);

        String finalMess = message1 + " " + message2 + ":" + message3;
        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(finalMess);
    }
}
