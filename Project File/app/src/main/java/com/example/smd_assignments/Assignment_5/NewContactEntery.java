package com.example.smd_assignments.Assignment_5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.smd_assignments.R;

import java.util.HashMap;

public class NewContactEntery extends AppCompatActivity {

    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    DbQueries dbQueries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_entery);
        firstName = findViewById(R.id.editfirstname);
        secondName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        dbQueries = new DbQueries(getApplicationContext());
    }

    public void SaveContact(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("secondName",secondName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());
        dbQueries.AddContact(contact);
        Log.d("TAG","Contact added successfully");
    }
}