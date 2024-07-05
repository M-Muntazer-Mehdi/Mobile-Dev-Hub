package com.example.smd_assignments.Assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smd_assignments.R;

public class Student_Activity_One extends AppCompatActivity {
    EditText editText_name, editText_CNIC, editText_phone, editText_sgpa, editText_cgpa;
    Button button_Save;
    Button button_back;

    String namesave, cnicsave, phonesave, sgpasave, cgpasave;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_Name = "name";
    private static final String KEY_Cnic = "cnic";
    private static final String KEY_Phone = "phone";
    private static final String KEY_Sgpa = "sgpa";
    private static final String KEY_Cgpa = "cgpa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_one);

        editText_name = findViewById(R.id.Student_name);
        editText_CNIC = findViewById(R.id.Student_cnic);
        editText_phone = findViewById(R.id.Student_phone);
        editText_sgpa = findViewById(R.id.Student_SGPA);
        editText_cgpa = findViewById(R.id.Student_CGPA);

        button_Save = findViewById(R.id.save);
        sharedPreferences = getSharedPreferences("Myuserprefs", Context.MODE_PRIVATE);

        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namesave = editText_name.getText().toString();
                cnicsave = editText_CNIC.getText().toString();
                phonesave = editText_phone.getText().toString();
                sgpasave = editText_sgpa.getText().toString();
                cgpasave = editText_cgpa.getText().toString();


                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", namesave);
                editor.putString("cnic", cnicsave);
                editor.putString("phone", phonesave);
                editor.putString("sgpa", sgpasave);
                editor.putString("cgpa", cgpasave);

                editor.commit();
                Toast.makeText(Student_Activity_One.this, "infomation save", Toast.LENGTH_LONG).show();
            }
        });

        button_back = findViewById(R.id.back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_Activity_One.this, Student_Main_Activity.class);
                startActivity(intent);
            }
        });
    }
}