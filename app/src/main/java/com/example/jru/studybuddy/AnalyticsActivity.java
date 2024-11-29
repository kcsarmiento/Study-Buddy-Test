package com.example.jru.studybuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AnalyticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v -> {
            Toast.makeText(AnalyticsActivity.this, "Add Task functionality here!", Toast.LENGTH_SHORT).show();
            // Open AddTaskActivity or similar functionality
        });
    }
}
