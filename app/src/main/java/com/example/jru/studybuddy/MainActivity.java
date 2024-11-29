package com.example.jru.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navAnalytics) {
                Toast.makeText(MainActivity.this, "Analytics Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navTimer) {
                Toast.makeText(MainActivity.this, "Timer Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navAddTask) {
                Toast.makeText(MainActivity.this, "Task Manager Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navNotes) {
                Intent notesIntent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(notesIntent);
                return true;
            } else if (id == R.id.navCalendar) {
                Intent calendarIntent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(calendarIntent);
                return true;
            }
            return false;
        });

    }
}
