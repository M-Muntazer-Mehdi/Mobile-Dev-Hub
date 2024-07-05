package com.example.smd_assignments.Assignment_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smd_assignments.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Firebase_Search_Delete_MainActivity extends AppCompatActivity {

    EditText number;
    EditText edtname;
    EditText edtdept;
    EditText edtregno;
    EditText edtcgpa;
    EditText edtemail;
    Button delete, search, update;
    FirebaseDatabase database;
    DatabaseReference reference;
    Task<Void> reference1;
    Button button_back_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_search_delete_main);

        number = findViewById(R.id.txtRegNoSearch);
        delete = findViewById(R.id.buttonDelete);
        search = findViewById(R.id.buttonSearch);
        update = findViewById(R.id.buttonUpdate);
        edtname = findViewById(R.id.txtsetname);
        edtdept = findViewById(R.id.txtsetdept);
        edtcgpa = findViewById(R.id.txtsetcgpa);
        edtemail = findViewById(R.id.txtsetemail);

        database = FirebaseDatabase.getInstance("https://smd-assignments-default-rtdb.firebaseio.com/");
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search = number.getText().toString();
                DeleteIntoFirebaseDatabase(Search);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search = number.getText().toString();
                SearchIntoFirebaseDatabase(Search);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search = number.getText().toString();
                UpdateIntoFirebaseDatabase(Search);
            }
        });

        button_back_2 = findViewById(R.id.back4);

        button_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Firebase_Search_Delete_MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void DeleteIntoFirebaseDatabase(String id)
    {
        reference = database.getReference().child("Students").child(id);
        reference.removeValue();
    }

    public void SearchIntoFirebaseDatabase(String id)
    {
        reference = database.getReference().child("Students").child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                String name = datasnapshot.child("name").getValue().toString();
                String dept = datasnapshot.child("dept").getValue().toString();
                String cgpa = datasnapshot.child("cgpa").getValue().toString();
                String email = datasnapshot.child("email").getValue().toString();

                edtname.setText(name);
                edtdept.setText(dept);
                edtcgpa.setText(cgpa);
                edtemail.setText(email);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void UpdateIntoFirebaseDatabase(String id)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name",edtname.getText().toString());
        map.put("dept",edtdept.getText().toString());
        map.put("cgpa",edtcgpa.getText().toString());
        map.put("email",edtemail.getText().toString());
        reference1 = database.getReference().child("Students").child(id).updateChildren(map);
    }
}