package com.example.anjali.medicine_reminder_app;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends BaseAdapter{
   Context context;
    String med_name;
    String date;
    String time;
    private List<list> mlist;
    LayoutInflater inflater;

    //constructor
    public Myadapter(Context context,List<list>mlist)
    {
        this.context=context;
        this.mlist=mlist;
    }
    @Override
    public int getCount()
    {
        return mlist.size();
    }

    @Override
    public Object getItem(int i)
    {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        /*View v = inflater.inflate(R.layout.list, null);
        TextView name=(TextView)v.findViewById(R.id.textView4);
        TextView datee=(TextView)v.findViewById(R.id.textView5);
        TextView timee=(TextView)v.findViewById(R.id.textView6);
        name.setText(med_name);
        datee.setText(date);
        timee.setText(time);*/
        View v = convertView;
        Myadapter viewHolder;
        if(v==null) {
            v = View.inflate(context, R.layout.list, null);
            TextView name = (TextView) v.findViewById(R.id.textView4);
            TextView datee = (TextView) v.findViewById(R.id.textView5);
            TextView timee = (TextView) v.findViewById(R.id.textView6);
            // set text for textview

            name.setText(mlist.get(i).getMed_name());
            datee.setText(mlist.get(i).getDate());
            timee.setText(mlist.get(i).getTime());
        }

        return  v;

    }



    }
