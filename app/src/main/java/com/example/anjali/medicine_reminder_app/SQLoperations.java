package com.example.anjali.medicine_reminder_app;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SQLoperations {
    Context context;
    SQLiteDatabase db;
    ArrayAdapter<list>adapter;

    SQLoperations(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("userDB", context.MODE_PRIVATE, null);
    }

    void createTable() {
        db.execSQL("CREATE TABLE if not exists Medicine(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "task TEXT," + "date TEXT," + "time TEXT)");
    }

    void insert(String med_name, String date, String time) {
        db.execSQL("INSERT or replace INTO Medicine (task,date,time) VALUES('" + med_name + "','" + date + "','" + time + "')");
    }
    ArrayList<List> getdata() {
        Cursor c = db.rawQuery("SELECT * FROM Medicine", null);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<List> list1 = new ArrayList<>();
        list.clear();
        if (c.moveToFirst()) {
            do {
                list=new ArrayList<String>();
                int index = c.getColumnIndex("id");
                String note1 = c.getString(1);
                String note2 = c.getString(2);
                String note3 = c.getString(3);
                list.add(note1);
                list.add(note2);
                list.add(note3);
                list1.add(list);
            } while (c.moveToNext());
        }
        return list1;
    }
}
