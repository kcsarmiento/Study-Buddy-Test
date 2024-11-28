package com.example.jru.studybuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    private EditText noteInput;
    private TextView notesList;
    private List<String> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        // Initialize UI Components
        noteInput = findViewById(R.id.noteInput);
        notesList = findViewById(R.id.notesList);
        Button saveNoteButton = findViewById(R.id.saveNoteButton);

        // Initialize Notes List
        notes = new ArrayList<>();

        // Save Note Button Listener
        saveNoteButton.setOnClickListener(v -> {
            String note = noteInput.getText().toString();
            if (!note.isEmpty()) {
                notes.add(note);
                displayNotes();
                noteInput.setText(""); // Clear input field
                Toast.makeText(NotesActivity.this, "Note Saved!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(NotesActivity.this, "Please enter a note!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Display Notes in the TextView
    private void displayNotes() {
        StringBuilder notesDisplay = new StringBuilder();
        for (String note : notes) {
            notesDisplay.append("- ").append(note).append("\n");
        }
        notesList.setText(notesDisplay.toString());
    }
}
