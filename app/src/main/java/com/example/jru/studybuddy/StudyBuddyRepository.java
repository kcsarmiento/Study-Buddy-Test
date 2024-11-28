package com.example.jru.studybuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudyBuddyRepository {
    private final SQLiteDatabase database;

    public StudyBuddyRepository(Context context) {
        StudyBuddyDatabaseHelper dbHelper = new StudyBuddyDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertTask(String title, String description) {
        ContentValues values = new ContentValues();
        values.put(StudyBuddyDatabaseHelper.COLUMN_TITLE, title);
        values.put(StudyBuddyDatabaseHelper.COLUMN_DESCRIPTION, description);
        return database.insert(StudyBuddyDatabaseHelper.TABLE_TASKS, null, values);
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        Cursor cursor = database.query(
                StudyBuddyDatabaseHelper.TABLE_TASKS,
                null, null, null, null, null, null
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(StudyBuddyDatabaseHelper.COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(StudyBuddyDatabaseHelper.COLUMN_TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(StudyBuddyDatabaseHelper.COLUMN_DESCRIPTION));
            tasks.add(new Task(id, title, description));
        }
        cursor.close();
        return tasks;
    }

    public int updateTask(int taskId, String newTitle, String newDescription) {
        ContentValues values = new ContentValues();
        values.put(StudyBuddyDatabaseHelper.COLUMN_TITLE, newTitle);
        values.put(StudyBuddyDatabaseHelper.COLUMN_DESCRIPTION, newDescription);
        return database.update(
                StudyBuddyDatabaseHelper.TABLE_TASKS,
                values,
                StudyBuddyDatabaseHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(taskId)}
        );
    }

    public int deleteTask(int id) {
        return database.delete(
                StudyBuddyDatabaseHelper.TABLE_TASKS,
                StudyBuddyDatabaseHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }
}
