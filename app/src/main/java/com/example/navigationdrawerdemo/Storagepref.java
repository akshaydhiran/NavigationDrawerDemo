package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Storagepref extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
