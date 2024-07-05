package com.example.smd_assignments.Assignment_6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smd_assignments.Assignment_2.Student_Activity_Two;
import com.example.smd_assignments.Assignment_2.Student_Main_Activity;
import com.example.smd_assignments.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase_Insert_MainActivity extends AppCompatActivity {
    EditText edtname,edtdept,edtregno,edtcgpa,edtemail;
    Button insert;
    FirebaseDatabase database;
    DatabaseReference reference;
    Button button_back_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_insert_main);

        edtname = findViewById(R.id.txtName);
        edtdept = findViewById(R.id.txtDept);
        edtregno = findViewById(R.id.txtRegno);
        edtcgpa = findViewById(R.id.txtCgpa);
        edtemail = findViewById(R.id.txtEmail);

        database = FirebaseDatabase.getInstance("https://smd-assignments-default-rtdb.firebaseio.com/");
        reference = database.getReference().child("Students");

        insert = findViewById(R.id.buttonInsert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertIntoFirebaseDatabase();
            }
        });

        button_back_2 = findViewById(R.id.back3);

        button_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Firebase_Insert_MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void InsertIntoFirebaseDatabase()
    {
        String name = edtname.getText().toString();
        String dept = edtdept.getText().toString();
        String regno = edtregno.getText().toString();
        String cgpa = edtcgpa.getText().toString();
        String email = edtemail.getText().toString();

        Students students = new Students(name,dept,regno,cgpa,email);
        reference.child(regno).setValue(students);
        Toast.makeText(this, "Data Inserted!", Toast.LENGTH_SHORT).show();
    }
}