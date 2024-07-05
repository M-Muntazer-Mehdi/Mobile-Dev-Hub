package com.example.smd_assignments.Assignment_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smd_assignments.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Firebase_Search_Greater_MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView textView1;

    ArrayList<Students> student_ArrayList;
    RecyclerView recyclerView;
    FireBase_Adapter adapter;

    Button button_back_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_search_greater_main);

        recyclerView = findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance("https://smd-assignments-default-rtdb.firebaseio.com/");
        reference = database.getReference("Students");

        student_ArrayList = new ArrayList<>();
        ReadDataFromFirebase();

        button_back_2 = findViewById(R.id.back5);

        button_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Firebase_Search_Greater_MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void ReadDataFromFirebase() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot1 : datasnapshot.getChildren()) {
                    Students student = new Students();
                    student.setName(snapshot1.child("name").getValue().toString());
                    student.setDept(snapshot1.child("dept").getValue().toString());
                    student.setCgpa(snapshot1.child("cgpa").getValue().toString());
                    String cgpa = snapshot1.child("cgpa").getValue().toString();
                    float number = Float.parseFloat(cgpa);
                    if(number >= 3.0) {
                        student_ArrayList.add(student);
                    }
                }
                adapter = new FireBase_Adapter(student_ArrayList,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}