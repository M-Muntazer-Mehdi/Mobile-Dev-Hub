package com.example.smd_assignments.Assignment_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smd_assignments.R;

import java.util.Arrays;
import java.util.Collections;

public class Student_Activity_Two extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    String[] country;
    ListView listView;

    Button button_back_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_two);

        listView = findViewById(R.id.listview1);


        sharedPreferences = getApplication().getSharedPreferences("Myuserprefs", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String cnic = sharedPreferences.getString("cnic", "");
        String phone = sharedPreferences.getString("phone", "");
        String sgpa = sharedPreferences.getString("sgpa", "");
        String cgpa = sharedPreferences.getString("cgpa", "");

        country = new String[]{name,cnic,phone,sgpa,cgpa,""};

        ArrayAdapter adapter = new ArrayAdapter<String>(Student_Activity_Two.this, R.layout.custom_list_view, R.id.nameid, country)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if(position % 2 == 1)
                {
                    view.setBackgroundColor(getResources().getColor(
                            android.R.color.system_accent2_500
                    ));
                }
                else {
                    if(position == 0)
                    {
                        view.setBackground(getResources().getDrawable(
                                R.drawable.rounded_corner_backgound_3
                                ));
                    }
                    else {
                        view.setBackgroundColor(getResources().getColor(
                                android.R.color.system_accent3_600
                        ));
                    }
                }
                return view;
            }
        };
        listView.setAdapter(adapter);

        button_back_2 = findViewById(R.id.back2);

        button_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_Activity_Two.this, Student_Main_Activity.class);
                startActivity(intent);
            }
        });

    }
}