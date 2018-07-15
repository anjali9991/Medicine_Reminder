package com.example.anjali.medicine_reminder_app;

/**
 * Created by Anjali on 14-07-2018.
 */

public class list {
    String med_name;
    String date;
    String time;

    //constructor
    list(String med_name,String date,String time)
    {
        this.med_name=med_name;
        this.date=date;
        this.time=time;
    }
    //getter,setter

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
