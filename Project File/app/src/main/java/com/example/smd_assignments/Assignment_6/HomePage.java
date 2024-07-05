package com.example.smd_assignments.Assignment_6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smd_assignments.R;

public class HomePage extends AppCompatActivity {

    Button records, delete_update, reports;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        records = findViewById(R.id.Record);
        delete_update = findViewById(R.id.delete_update);
        reports = findViewById(R.id.Reports);

        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Insert_MainActivity.class);
                startActivity(intent);
            }
        });

        delete_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Search_Delete_MainActivity.class);
                startActivity(intent);
            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Reports_MainActivity.class);
                startActivity(intent);
            }
        });
    }
}