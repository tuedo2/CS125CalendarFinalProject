package com.example.android.cs125_calendar_final_project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Here's the idea: you can click on one of the dates in mainView (the calendar) and then each day
 * has it's own editable text. When you click the "save" button the text is saved for that day and
 * you can reaccess it. That's pretty much it.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Widget stuff.
         */
        CalendarView mainView = findViewById(R.id.mainView);
        TextView eventText = findViewById(R.id.eventList);
        Button saveButton = findViewById(R.id.saveButton);

        /**
         * Default stuff.
         */
        eventText.setFocusable(true); // Making the textView editable
        eventText.setEnabled(true);
        eventText.setClickable(true);
        eventText.setFocusableInTouchMode(true);
    }
}
