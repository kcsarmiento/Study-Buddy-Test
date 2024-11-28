package com.example.jru.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudyBuddyRepository repository;
    private EditText taskTitleEditText, taskDescriptionEditText, taskIdEditText;
    private TextView taskListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Repository
        repository = new StudyBuddyRepository(this);

        // Initialize UI Components
        taskTitleEditText = findViewById(R.id.taskTitleEditText);
        taskDescriptionEditText = findViewById(R.id.taskDescriptionEditText);
        taskIdEditText = findViewById(R.id.taskIdEditText);
        taskListTextView = findViewById(R.id.taskListTextView);

        Button addTaskButton = findViewById(R.id.addTaskButton);
        Button updateTaskButton = findViewById(R.id.updateTaskButton);
        Button deleteTaskButton = findViewById(R.id.deleteTaskButton);
        Button calendarButton = findViewById(R.id.calendarButton);
        Button notesButton = findViewById(R.id.notesButton);

        // Add Task Button Listener
        addTaskButton.setOnClickListener(v -> {
            String title = taskTitleEditText.getText().toString();
            String description = taskDescriptionEditText.getText().toString();

            if (!title.isEmpty()) {
                repository.insertTask(title, description);
                displayTasks();
                taskTitleEditText.setText("");
                taskDescriptionEditText.setText("");
                Toast.makeText(MainActivity.this, "Task Added Successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Task title is required.", Toast.LENGTH_SHORT).show();
            }
        });

        // Update Task Button Listener
        updateTaskButton.setOnClickListener(v -> {
            try {
                int taskId = Integer.parseInt(taskIdEditText.getText().toString());
                String newTitle = taskTitleEditText.getText().toString();
                String newDescription = taskDescriptionEditText.getText().toString();

                if (!newTitle.isEmpty()) {
                    int rowsUpdated = repository.updateTask(taskId, newTitle, newDescription);
                    if (rowsUpdated > 0) {
                        displayTasks();
                        Toast.makeText(MainActivity.this, "Task Updated Successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Task Not Found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Task title is required.", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid Task ID.", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete Task Button Listener
        deleteTaskButton.setOnClickListener(v -> {
            try {
                int taskId = Integer.parseInt(taskIdEditText.getText().toString());
                int rowsDeleted = repository.deleteTask(taskId);
                if (rowsDeleted > 0) {
                    displayTasks();
                    Toast.makeText(MainActivity.this, "Task Deleted Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Task Not Found.", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid Task ID.", Toast.LENGTH_SHORT).show();
            }
        });

        // Calendar Button Listener
        calendarButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        // Notes Button Listener
        notesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intent);
        });

        // Display tasks on startup
        displayTasks();
    }

    // Method to Display Tasks
    private void displayTasks() {
        List<Task> tasks = repository.getAllTasks();
        StringBuilder taskList = new StringBuilder();
        for (Task task : tasks) {
            taskList.append("ID: ").append(task.getId())
                    .append("\nTitle: ").append(task.getTitle())
                    .append("\nDescription: ").append(task.getDescription())
                    .append("\n\n");
        }
        taskListTextView.setText(taskList.toString());
    }
}
