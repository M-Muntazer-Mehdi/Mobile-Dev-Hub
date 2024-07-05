package com.example.smd_assignments.Assignment_5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbQueries extends SQLiteOpenHelper {
    public DbQueries(@Nullable Context context) {
        super(context, "ContactsDB", null, 1);
        Log.d("TAG","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE CONTACTS("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "firstName TEXT,"+
                "secondName TEXT,"+
                "phoneNumber TEXT,"+
                "emailAddress TEXT,"+
                "homeAddress TEXT)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void AddContact(HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        db.insert("CONTACTS",null,contentValues);
    }

    public ArrayList<HashMap<String, String>> getAllContacts() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String,String>> contactList = new ArrayList<HashMap<String, String>>();
        String Query = "SELECT * FROM CONTACTS";
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToNext()){
            do{
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("_id",cursor.getString(0));
                hashMap.put("firstName", cursor.getString(1));
                hashMap.put("secondName", cursor.getString(2));
                hashMap.put("phoneNumber", cursor.getString(3));
                hashMap.put("emailAddress", cursor.getString(4));
                hashMap.put("homeAddress", cursor.getString(5));
                contactList.add(hashMap);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    public HashMap<String, String> getSingleContact(String id) {
        SQLiteDatabase db = getReadableDatabase();
        HashMap<String,String> hashMap = new HashMap<String, String>();
        String Query = "SELECT * FROM CONTACTS WHERE _ID="+id;
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToFirst()){
            do{
                hashMap.put("_id",cursor.getString(0));
                hashMap.put("firstName", cursor.getString(1));
                hashMap.put("secondName", cursor.getString(2));
                hashMap.put("phoneNumber", cursor.getString(3));
                hashMap.put("emailAddress", cursor.getString(4));
                hashMap.put("homeAddress", cursor.getString(5));
            }while(cursor.moveToNext());
        }
        return hashMap;
    }

    public void updateContact(HashMap<String, String> updateContact,String id) {
        SQLiteDatabase db = getWritableDatabase();
        String firstName = updateContact.get("firstName");
        String secondName = updateContact.get("secondName");
        String phoneNumber = updateContact.get("phoneNumber");
        String emailAddress = updateContact.get("emailAddress");
        String homeAddress = updateContact.get("homeAddress");
        String Query= "UPDATE CONTACTS SET firsName='"+firstName+"' ,secondName='"+secondName+"' ,phoneNumber='"+phoneNumber+"' " +
                ",emailAddress='"+emailAddress+"' ,homeAddress='"+homeAddress+"' WHERE _id="+id;
        db.execSQL(Query);
    }

    public void deleteContact(HashMap<String, String> updateContact, String id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",updateContact.get("_id"));
        db.delete("CONTACTS","_id="+id,null);
    }
}
