package com.example.lab5_milestone1_boukhankov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey = "username";

    public void clickFunction(View view) {
        EditText name = (EditText) findViewById(R.id.editTextUserName);
        String str = name.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1_boukhankov", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();
        goToNotesActivity(str);
    }

    public void goToNotesActivity(String s) {
        Intent intent = new Intent(this, Notes.class);
        intent.putExtra("name", s);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1_boukhankov", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(usernameKey, "").equals("")){
            goToNotesActivity(sharedPreferences.getString(usernameKey, ""));
        } else {
            setContentView(R.layout.activity_main);
        }
    }
}