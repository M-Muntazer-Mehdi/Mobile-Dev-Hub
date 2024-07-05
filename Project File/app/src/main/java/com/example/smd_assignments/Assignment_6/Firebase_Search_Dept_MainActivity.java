package com.example.smd_assignments.Assignment_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smd_assignments.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Firebase_Search_Dept_MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView textView1;

    ArrayList<Students> student_ArrayList, student_ArrayList1;
    RecyclerView recyclerView, recyclerView1;
    FireBase_Adapter adapter, adapter1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_search_dept_main);

        recyclerView = findViewById(R.id.firebaserecyclerview);
        recyclerView1 = findViewById(R.id.firebaserecyclerview1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView1.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance("https://smd-assignments-default-rtdb.firebaseio.com/");
        reference = database.getReference("Students");

        student_ArrayList = new ArrayList<>();
        student_ArrayList1 = new ArrayList<>();
        ReadDataFromFirebase();
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
                    String dept = snapshot1.child("dept").getValue().toString();
                    if(dept.equals("SE")) {
                        student_ArrayList.add(student);
                    }
                    else if(dept.equals("CS")) {
                        student_ArrayList1.add(student);
                    }
                }
                adapter = new FireBase_Adapter(student_ArrayList,getApplicationContext());
                adapter1 = new FireBase_Adapter(student_ArrayList1,getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView1.setAdapter(adapter1);
                adapter.notifyDataSetChanged();
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}