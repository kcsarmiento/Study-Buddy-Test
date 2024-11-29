package com.example.jru.studybuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar); // Ensure `activity_calendar.xml` exists

        // Initialize views
        Button addTaskButton = findViewById(R.id.addTaskButton); // Ensure `addTaskButton` exists in your XML

        // Set listener for the Add Task button
        addTaskButton.setOnClickListener(v ->
                Toast.makeText(CalendarActivity.this, "Add Task Clicked!", Toast.LENGTH_SHORT).show()
        );
    }
}
