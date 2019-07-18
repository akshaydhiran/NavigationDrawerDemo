package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StorePreferenceActivity extends AppCompatActivity {
    TextView textView;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_preference);
        button = findViewById(R.id.storedetails);
        button2 = findViewById(R.id.showdetails);
        textView = findViewById(R.id.details);
       // addPreferencesFromResource(R.xml.preference);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.storedetails:

                        Intent intent = new Intent(StorePreferenceActivity.this,Storagepref.class);
                        startActivity(intent);
                        break;
                    case R.id.showdetails:
                        displaySharedPreferences();
                        break;
                    default:
                        break;
                }

            }
        };
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
    }

    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(StorePreferenceActivity.this);
        String username = prefs.getString("username", "Default NickName");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");


        StringBuilder builder = new StringBuilder();
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + passw + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listPrefs);
        textView.setText(builder.toString());
    }
}