package com.example.smd_assignments.Assignment_5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.smd_assignments.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactList_MainActivity extends AppCompatActivity {

    DbQueries dbQueries;
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_main);
        dbQueries = new DbQueries(getApplicationContext());
        listView = findViewById(R.id.lstmaincontactlist);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<HashMap<String,String>> contactList = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this,contactList,R.layout.sqlnewlayout_contactlist, new String[]{"firstName","secondName","phoneNumber"},
                new int[]{R.id.txtfirstname,R.id.txtsecondname,R.id.txtphonenumber});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(ContactList_MainActivity.this,Update_Delete_ContactList.class);
                intent.putExtra("id",String.valueOf(position+1));
                startActivity(intent);
            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(this, NewContactEntery.class);
        startActivity(intent);
    }
}