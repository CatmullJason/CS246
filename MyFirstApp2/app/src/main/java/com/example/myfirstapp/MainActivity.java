package com.example.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String BOOK = "com.example.myfirstapp.BOOK";
    public static final String CHAPTER = "com.example.myfirstapp.CHAPTER";
    public static final String VERSE = "com.example.myfirstapp.VERSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Log.i("intent", "About to create intent with John 3:16");
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //retrieve data from text fields
        EditText verse = (EditText) findViewById(R.id.editText);
        EditText book = (EditText) findViewById(R.id.editText2);
        EditText chapter = (EditText) findViewById(R.id.editText3);

        //assign them to strings to manage format
        String message1 = verse.getText().toString();
        String message2 = book.getText().toString();
        String message3 = chapter.getText().toString();

        //include them in our intent
        intent.putExtra(BOOK, message2);
        intent.putExtra(CHAPTER, message3);
        intent.putExtra(VERSE, message1);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences mSharedPreference = getSharedPreferences("ID", 0);
        String value = (mSharedPreference.getString("BOOK", ""));
        String value2 = (mSharedPreference.getString("CHAPTER", ""));
        String value3 = (mSharedPreference.getString("VERSE", ""));

        //couldn't get this to work without declaring these all over again
        EditText verse = (EditText) findViewById(R.id.editText);
        EditText book = (EditText) findViewById(R.id.editText2);
        EditText chapter = (EditText) findViewById(R.id.editText3);

        //set our EditText objects with our saved values
        verse.setText(value3);
        book.setText(value);
        chapter.setText(value2);
    }
}
