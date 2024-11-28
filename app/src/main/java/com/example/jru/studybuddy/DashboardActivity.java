package com.example.jru.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private TextView taskCount, taskDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize Views
        taskCount = findViewById(R.id.taskCount);
        taskDate = findViewById(R.id.taskDate);

        // Update Task Stats
        updateTaskStats();

        // Navigation to Task Manager
        ImageView navAddTask = findViewById(R.id.navAddTask);
        navAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void updateTaskStats() {
        // Mock Data for Now
        taskCount.setText("20+");  // Replace with real data later
        taskDate.setText("Jan 25, 2025");
    }
}
