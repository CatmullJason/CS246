package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    static final String PREFS_NAME = "com.example.myfirstapp_scriptures";

    String message1;
    String message2;
    String message3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("intent", "Received intent with John 3:16");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the strings
        Intent intent = getIntent();
        message1 = intent.getStringExtra(MainActivity.BOOK);
        message2 = intent.getStringExtra(MainActivity.CHAPTER);
        message3 = intent.getStringExtra(MainActivity.VERSE);

        //proper formatting
        String finalMess = message1 + " " + message2 + ":" + message3;

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(finalMess);
    }

    public void saveScripture(View view) {
        //save scripture to shared preferences
        SharedPreferences prefs = getSharedPreferences("ID", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("BOOK", message1);
        editor.putString("CHAPTER", message2);
        editor.putString("VERSE", message3);
        editor.commit();

        //Toast letting user know that scripture was saved
        Context context = getApplicationContext();
        CharSequence text = "Scripture Saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
