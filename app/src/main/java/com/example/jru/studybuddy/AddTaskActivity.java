package com.example.jru.studybuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText taskTitleEditText, taskDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskTitleEditText = findViewById(R.id.taskTitleEditText);
        taskDescriptionEditText = findViewById(R.id.taskDescriptionEditText);
        Button saveTaskButton = findViewById(R.id.saveTaskButton);

        saveTaskButton.setOnClickListener(v -> {
            String title = taskTitleEditText.getText().toString();
            String description = taskDescriptionEditText.getText().toString();

            if (!title.isEmpty()) {
                StudyBuddyRepository repository = new StudyBuddyRepository(this);
                repository.insertTask(title, description);
                Toast.makeText(this, "Task Added Successfully!", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity
            } else {
                Toast.makeText(this, "Task Title is required!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
