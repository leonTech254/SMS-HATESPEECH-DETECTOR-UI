package com.leonteqsecurity.messagechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }
    
    public  void toScan(View view)
    {
        Intent intent = new Intent(this,ScanMessages.class);
        startActivity(intent);
    }
}