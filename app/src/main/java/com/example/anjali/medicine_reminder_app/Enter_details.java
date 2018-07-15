package com.example.anjali.medicine_reminder_app;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;


import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class Enter_details extends AppCompatActivity implements View.OnClickListener {
    Button btnDatePicker, btnTimePicker, button;
    EditText txtDate, txtTime, med_name;
    private int mYear, mMonth, mDay, mHour, mMinute;
    AlarmManager alarm_Manager;
    SQLoperations sqLoperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        sqLoperations = new SQLoperations(getApplicationContext());
        med_name = (EditText) findViewById(R.id.editText2);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        button = (Button) findViewById(R.id.button3);
        View v;
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLoperations.insert(med_name.getText().toString(), txtDate.getText().toString(), txtTime.getText().toString());
                Intent intent = new Intent(Enter_details.this, MainActivity.class);
                intent.putExtra("med_name", med_name.getText().toString());
                intent.putExtra("date", txtDate.getText().toString());
                intent.putExtra("time", txtTime.getText().toString());
                startAlert();
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);

            timePickerDialog.show();

        }
    }
    public void startAlert() {

        int i=mHour*3600000+mMinute*60000;
        //int i = Integer.parseInt(mHour.getText().toString());
        Intent intent = new Intent(this,AlarmReceive.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i), pendingIntent);
        Toast.makeText(this, "Alarm is set",Toast.LENGTH_LONG).show();
    }
}




