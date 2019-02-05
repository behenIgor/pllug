package com.example.igor.pizz_order_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.igor.pizz_order_fragments.fragments.FragmentOne;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragmentOne();
        Log.d(LOG_TAG, "MainActivity onCreate +9");
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
        Log.d(LOG_TAG, "MainActivity replaceFragment +7");
    }
    public void showFragmentOne() {
        replaceFragment(new FragmentOne());
        Log.d(LOG_TAG, "MainActivity showFragmentOne +8");
    }




















































}
