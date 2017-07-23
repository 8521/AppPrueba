package com.ilaquidain.cronometro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by ilaquidain on 20/11/2015.
 */
public class countdown_activity extends Activity {
    private TextView day1;
    private TextView hour1;
    private TextView minute1;
    private TextView second1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        day1 = (TextView) findViewById(R.id.day1);
        hour1 = (TextView) findViewById(R.id.hour1);
        minute1 = (TextView) findViewById(R.id.minute1);
        second1 = (TextView) findViewById(R.id.second1);
        updatetime();

        final Runnable refresh = new Runnable() {
            @Override
            public void run() {
                updatetime();
            }
        };

        Thread updateThread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(refresh);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        updateThread.start();
    }
    private void updatetime(){


        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        DateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar futuredate = new GregorianCalendar();
        Calendar currentdate = new GregorianCalendar();
        futuredate.set(2015,11,14,8,35,0);
        Long timedifference = futuredate.getTimeInMillis() - currentdate.getTimeInMillis();
        Integer daysbetween = 0;
        while(currentdate.before(futuredate)){
            currentdate.add(Calendar.DAY_OF_MONTH, 1);
            daysbetween++;
        }
        Integer hoursbetween = 0;
        int hourfuture = futuredate.get(Calendar.HOUR_OF_DAY);
        int hourcurrent = currentdate.get(Calendar.HOUR_OF_DAY);
        hoursbetween = (hourfuture - hourcurrent);
        if(hoursbetween < 0){
            daysbetween = daysbetween-1;
            hoursbetween = hoursbetween+24;
        }
        Integer minutesbetween = 0;
        int minutefuture = futuredate.get(Calendar.MINUTE);
        int minutecurrent = currentdate.get(Calendar.MINUTE);
        minutesbetween = minutefuture-minutecurrent;
        if (minutesbetween < 0) {
            hoursbetween = hoursbetween-1;
            if(hoursbetween < 0){
                daysbetween = daysbetween-1;
                hoursbetween = hoursbetween+24;
            }
            minutesbetween = minutesbetween+60;
        }
        Integer secondsbetween = 0;
        int secondsfuture = futuredate.get(Calendar.SECOND);
        int secondscurrent = currentdate.get(Calendar.SECOND);
        secondsbetween = secondsfuture - secondscurrent;
        if (secondsbetween<0){
            minutesbetween = minutesbetween-1;
            if (minutesbetween < 0) {
                hoursbetween = hoursbetween-1;
                if(hoursbetween < 0){
                    daysbetween = daysbetween-1;
                    hoursbetween = hoursbetween+24;
                }
                minutesbetween = minutesbetween+60;
            }
            secondsbetween=secondsbetween+60;
        }

        day1.setText(daysbetween.toString());
        hour1.setText(hoursbetween.toString());
        minute1.setText(minutesbetween.toString());
        second1.setText(secondsbetween.toString());

        /*Toast.makeText(countdown_activity.this, dateformat1.format(currentdate.getTimeInMillis()), Toast.LENGTH_SHORT).show();
        Toast.makeText(countdown_activity.this, dateformat1.format(futuredate.getTimeInMillis()), Toast.LENGTH_SHORT).show();
        Toast.makeText(countdown_activity.this, timedifference.toString(), Toast.LENGTH_SHORT).show();*//*
        *//*Long lngday1 = (timedifference / (1000*24*60*60))/10;*//*
        *//*Toast.makeText(countdown_activity.this, day1.toString(), Toast.LENGTH_SHORT).show();*//*
        *//*Long lngday2 = (timedifference / (1000*24*60*60)) - lngday1*10;*//*
        *//*Toast.makeText(countdown_activity.this, day2.toString(), Toast.LENGTH_SHORT).show();*//*
        Long lnghour1 = (((timedifference) / (1000*60*60)) - (lngday1*10 + lngday2)*24)/10;
        Long lnghour2 = (((timedifference)/(1000*60*60)))- (lngday1*10 + lngday2)*24 - lnghour1*10;
        Long lngminute1 = (((timedifference)/(1000*60))-((lngday1*10+lngday2)*24*60-(lnghour1*10+lnghour2)*60))/10;
        Long lngminute2 = (((timedifference)/(1000*60))-((lngday1*10+lngday2)*24*60-(lnghour1*10+lnghour2)*60)-lngminute1*10);
        Long lngsecond1 = (((timedifference)/(1000))-(lngday1*10+lngday2)*24*60*60-(lnghour1*10+lnghour2)*60*60-(lngminute1*10+lngminute2)*60)/10;
        Long lngsecond2 = (((timedifference)/(1000))-(lngday1*10+lngday2)*24*60*60-(lnghour1*10+lnghour2)*60*60-(lngminute1*10+lngminute2)*60-lngsecond1*10);
        day1.setText(lngday1.toString());
        day2.setText(lngday2.toString());
        hour1.setText(lnghour1.toString());
        hour2.setText(lnghour2.toString());
        minute1.setText(lngminute1.toString());
        minute2.setText(lngminute2.toString());
        second1.setText(lngsecond1.toString());
        second2.setText(lngsecond2.toString());*/

    }
   }
