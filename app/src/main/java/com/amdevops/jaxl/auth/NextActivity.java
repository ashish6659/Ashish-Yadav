package com.amdevops.jaxl.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    Button mlogout;
    TextView mmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mmail=findViewById(R.id.nextEmail);
        mlogout=findViewById(R.id.nextLogout);

        mmail.setText(getdata());

        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdata("empty");
                Intent intet = new Intent(NextActivity.this, MainActivity.class);
                intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intet);
                finish();
            }
        });




    }

    private void setdata(String email) {

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(NextActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putString("email",email);
        myEditor.apply();
    }

    private String getdata(){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(NextActivity.this);
        String email = myPreferences.getString("email", "empty");
        return email;

    }
}