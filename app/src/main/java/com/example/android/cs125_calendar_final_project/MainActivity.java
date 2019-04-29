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

import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

/**
 * Here's the idea: you can click on one of the dates in mainView (the calendar) and then each day
 * has it's own editable text. When you click the "save" button the text is saved for that day and
 * you can reaccess it. That's pretty much it.
 */

public class MainActivity extends AppCompatActivity {
    /** Maps all dates to JSON strings */
    private Map<Date, String> allData;

    /** The big calendar thing. */
    private CalendarView mainView = findViewById(R.id.mainView);

    /** The editable text. */
    private TextView eventText = findViewById(R.id.eventList);

    /** The save button. */
    private Button saveButton = findViewById(R.id.saveButton);

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

        /** Replace the new Date constructer with something that gives the currently selected date. */
        saveButton.setOnClickListener((v) -> saveText(new Date(119, 4, 29), eventText.getText().toString()));

        /**
         * Default stuff.
         */
        eventText.setFocusable(true); // Making the textView editable
        eventText.setEnabled(true);
        eventText.setClickable(true);
        eventText.setFocusableInTouchMode(true);
    }

    /**
     * This function is called when the "Save" button is clicked. It assigns text to a map with the
     * key of the date of the map.
     * @param currentDate the date being saved
     * @param toSave text of the display (unparsed)
     */
    public void saveText(Date currentDate, String toSave) {
        if (toSave == null || toSave.equals("")) {
            return;
        }
        allData.put(currentDate, toSave);
    }

    /**
     * This function sets the "eventView" text field to either the text saved at the current date or
     * defaults to an empty String.
     * @param currentDate the date being called
     */
    public void getText(Date currentDate) {
        eventText.setText(allData.getOrDefault(currentDate, ""));
    }
}
