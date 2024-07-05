package com.example.smd_assignments.Assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smd_assignments.R;

public class Student_Main_Activity extends AppCompatActivity {
    private Button getid1;
    private Button getid2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        getid1 = findViewById(R.id.Activity1);
        getid2 = findViewById(R.id.Activity2);
        getid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_Main_Activity.this,Student_Activity_One.class);
                startActivity(intent);
            }
        });
        getid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_Main_Activity.this,Student_Activity_Two.class);
                startActivity(intent);
            }
        });
    }
}