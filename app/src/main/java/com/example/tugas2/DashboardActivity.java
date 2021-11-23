package com.example.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void openregistration(View v){
        Intent intent = new Intent(DashboardActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
