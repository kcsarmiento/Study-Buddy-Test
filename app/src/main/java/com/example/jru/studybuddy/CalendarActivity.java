package com.example.jru.studybuddy;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    private TextView selectedDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Initialize UI Components
        CalendarView calendarView = findViewById(R.id.calendarView);
        selectedDateText = findViewById(R.id.selectedDateText);

        // Set Current Date as Default
        String currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        selectedDateText.setText("Selected Date: " + currentDate);

        // Set Listener for Date Selection
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = (month + 1) + "/" + dayOfMonth + "/" + year;
            selectedDateText.setText("Selected Date: " + selectedDate);
        });
    }
}
