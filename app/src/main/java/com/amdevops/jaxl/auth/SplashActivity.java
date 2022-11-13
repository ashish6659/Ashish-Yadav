package com.amdevops.jaxl.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (getdata().equals("empty")) {
                    Intent intet = new Intent(SplashActivity.this, MainActivity.class);
                    intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intet);
                    finish();
                }else{
                    Intent intet = new Intent(SplashActivity.this, NextActivity.class);
                    intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intet);
                    finish();
                }



            }
        }, 3000);

    }

    private String getdata(){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        String email = myPreferences.getString("email", "empty");
       return email;

    }
}