package com.example.smd_assignments.Assignment_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.smd_assignments.R;

import java.util.HashMap;

public class Update_Delete_ContactList extends AppCompatActivity {

    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    DbQueries dbQueries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_contact_list);
        dbQueries = new DbQueries(getApplicationContext());
        //Binding...
        firstName = findViewById(R.id.editfirstname);
        secondName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> singleContact = dbQueries.getSingleContact(id);
        Log.d("TAG","The next work will be done by me");

        firstName.setText(singleContact.get("firstName"));
        secondName.setText(singleContact.get("secondName"));
        phoneNumber.setText(singleContact.get("phoneNumber"));
        emailAddress.setText(singleContact.get("emailAddress"));
        homeAddress.setText(singleContact.get("homeAddress"));
        dbQueries = new DbQueries(getApplicationContext());
    }


    public void UpdateRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> updateContact = new HashMap<String, String>();
        updateContact.put("firstName",firstName.getText().toString());
        updateContact.put("secondName",secondName.getText().toString());
        updateContact.put("phoneNumber",phoneNumber.getText().toString());
        updateContact.put("emailAddress",emailAddress.getText().toString());
        updateContact.put("homeAddress",homeAddress.getText().toString());
        dbQueries.updateContact(updateContact,id);
        Log.d("TAG","Data Updated Successfully");
        intent = new Intent(this,ContactList_MainActivity.class);
        startActivity(intent);
    }

    public void DeleteRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> updateContact = new HashMap<String, String>();
        dbQueries.deleteContact(updateContact, id);
        intent = new Intent(this,ContactList_MainActivity.class);
        startActivity(intent);
    }
}