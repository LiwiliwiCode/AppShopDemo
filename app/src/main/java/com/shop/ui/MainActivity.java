package com.shop.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import shop.com.appshopdemo.R;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


    }
}
