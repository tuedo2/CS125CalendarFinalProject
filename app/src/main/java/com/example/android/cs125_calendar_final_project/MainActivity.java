package com.example.android.cs125_calendar_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Here's the idea: you can click on one of the dates in mainView (the calendar) and then each day
 * has it's own editable text. When you click the "save" button the text is saved for that day and
 * you can re-access it. That's pretty much it.
 */

public class MainActivity extends AppCompatActivity {
    /** Maps all dates to JSON strings */
    private Map<GregorianCalendar, String> allData = new HashMap<>();

    /** The big calendar thing. */
    private CalendarView mainView;

    /** The editable text. */
    private TextView eventText;

    /** The save button. */
    private Button saveButton;

    private GregorianCalendar currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Widget stuff.
         */
        mainView = findViewById(R.id.mainView);
        eventText = findViewById(R.id.eventList);
        saveButton = findViewById(R.id.saveButton);

        /** Replace the new Date constructor with something that gives the currently selected date. */
        saveButton.setOnClickListener((v) -> saveText(currentDate, eventText.getText().toString()));

        /**
         * Sets the private variable "currentDate" to the selected date whenever you select a new
         * date.
         */
        mainView.setOnDateChangeListener((mainView, year, month, date) -> {
            currentDate = new GregorianCalendar(year, month, date);
            getText(currentDate);
        });

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
     * @param toSave text of the display
     */
    public void saveText(GregorianCalendar currentDate, String toSave) {
        if (currentDate == null || toSave.equals("")) {
            return;
        }
        allData.put(currentDate, toSave);
    }

    /**
     * This function sets the "eventView" text field to either the text saved at the current date or
     * defaults to an empty String.
     *
     * Can we make it so you don't have to manually delete "Editable!" every time?
     * @param currentDate the date being called
     */
    public void getText(GregorianCalendar currentDate) {
        eventText.setText(allData.getOrDefault(currentDate, ""));
    }
}
