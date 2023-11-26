package com.example.androidscaffolding.ui.Auth.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class TodoDatabaseHelper(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, TASK TEXT)")
        Log.d("TodoDatabaseHelper", "Database created")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
        Log.d("TodoDatabaseHelper", "Database upgraded")

    }

    fun addTask(task: String) {
        val db = this.writableDatabase
        db.execSQL("INSERT INTO $TABLE_NAME (TASK) VALUES ('$task')")
        db.close()
        Log.d("TodoDatabaseHelper", "Task added: $task")
    }

    @SuppressLint("Range")
    fun getAllTasks(): MutableList<String> {
        val taskList = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                taskList.add(cursor.getString(cursor.getColumnIndex("TASK")))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        Log.d("TodoDatabaseHelper", "Tasks fetched: ${taskList.size}")
        return taskList
    }

    companion object {
        private const val DATABASE_NAME = "TodoDatabase.db"
        private const val TABLE_NAME = "Tasks"
    }
}