package com.example.smd_assignments.Assignment_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smd_assignments.R;

public class Firebase_Reports_MainActivity extends AppCompatActivity {

    Button Greater, Less, deptcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_reports_main);

        Greater = findViewById(R.id.Greater);
        Less = findViewById(R.id.Less);
        deptcheck = findViewById(R.id.DeptCheck);

        Greater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Search_Greater_MainActivity.class);
                startActivity(intent);
            }
        });

        Less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Search_Less_MainActivity.class);
                startActivity(intent);
            }
        });

        deptcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Firebase_Search_Dept_MainActivity.class);
                startActivity(intent);
            }
        });
    }
}