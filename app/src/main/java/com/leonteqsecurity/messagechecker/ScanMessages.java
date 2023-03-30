package com.leonteqsecurity.messagechecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class ScanMessages extends AppCompatActivity {

    private static final int REQUEST_CODE_SMS_PERMISSION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_messages);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }


        checkSMSPermissions();

    }


    private void checkSMSPermissions() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS}, REQUEST_CODE_SMS_PERMISSION);
        } else {
            readSMS();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_SMS_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readSMS();
                } else {
                    Toast.makeText(this, "SMS permission is required to read SMS messages.", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    private void readSMS() {
        // Add your code to read SMS messages here
    }
}
