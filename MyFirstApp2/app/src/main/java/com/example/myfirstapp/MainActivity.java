package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
        EditText verse = (EditText) findViewById(R.id.editText);
        EditText book = (EditText) findViewById(R.id.editText2);
        EditText chapter = (EditText) findViewById(R.id.editText3);
        String message1 = verse.getText().toString();
        String message2 = book.getText().toString();
        String message3 = chapter.getText().toString();

        intent.putExtra(BOOK, message2);
        intent.putExtra(CHAPTER, message3);
        intent.putExtra(VERSE, message1);
        startActivity(intent);    }

}
