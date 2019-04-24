package com.example.android.cs125_calendar_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * CalendarView stuff.
         */
        CalendarView mainView = findViewById(R.id.mainView);
        TextView eventText = findViewById(R.id.eventList);
        eventText.setFocusable(true);
        eventText.setEnabled(true);
        eventText.setClickable(true);
        eventText.setFocusableInTouchMode(true);
    }
}
