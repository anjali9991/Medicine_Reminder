package com.example.anjali.medicine_reminder_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    final static private long ONE_SECOND = 1000;
    PendingIntent pi;
    BroadcastReceiver br;
    AlarmManager am;
    Button button;
    SQLoperations sqLoperations;
    ArrayAdapter<List>arrayAdapter;
    ListView listView;
    ArrayList<List>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        sqLoperations=new SQLoperations(getApplicationContext());
        sqLoperations.createTable();
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Enter_details.class);
                startActivity(intent);
                finish();
            }
        });
        displayList();
    }
    void displayList()
    {
        arrayList=sqLoperations.getdata();
        if(arrayList.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"List is empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Myadapter myadapter = new Myadapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
            //listView.setAdapter(myadapter);
             arrayAdapter = new ArrayAdapter<List>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }
    }
}

