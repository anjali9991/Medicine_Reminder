package com.example.anjali.medicine_reminder_app;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.TabHost;
import android.widget.Toast;

public class AlarmReceive extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context,"Take your medicine",Toast.LENGTH_SHORT).show();
        String get_your_string=intent.getExtras().getString("extra");
    }
}
