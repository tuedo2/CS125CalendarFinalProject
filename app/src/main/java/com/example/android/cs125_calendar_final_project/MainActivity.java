package com.example.android.cs125_calendar_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Here I try to set up each week as a different linear layout, so that we can put
         * each day (as a button) within a separate weekly linear layout
         */
        LinearLayout weekOneLayout = findViewById(R.id.calendar_week_1);
        LinearLayout weekTwoLayout = findViewById(R.id.calendar_week_2);
        LinearLayout weekThreeLayout = findViewById(R.id.calendar_week_3);
        LinearLayout weekFourLayout = findViewById(R.id.calendar_week_4);
        LinearLayout weekFiveLayout = findViewById(R.id.calendar_week_5);

        LinearLayout[] weeks = new LinearLayout[5];
        weeks[0] = weekOneLayout;
        weeks[1] = weekTwoLayout;
        weeks[2] = weekThreeLayout;
        weeks[3] = weekFourLayout;
        weeks[4] = weekFiveLayout;
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        buttonParams.weight = 1;
        // I'm not sure what's going wrong with my layouts, they seem to be stacked on top of each other.
        // Help please David!
    }
}
