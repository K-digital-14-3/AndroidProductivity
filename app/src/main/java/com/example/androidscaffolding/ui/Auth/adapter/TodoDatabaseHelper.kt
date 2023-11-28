package com.example.androidscaffolding.ui.Auth.adapter

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class TodoDatabaseHelper(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, TASK TEXT, TASKDESC TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addData(task: String, taskDesc: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("TASK", task)
        contentValues.put("TASKDESC", taskDesc)

        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result != -1L
    }


    val allData: List<String>
        get() {
            val tasks = mutableListOf<String>()
            val db = this.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

            if (cursor.moveToFirst()) {
                do {
                    val task = cursor.getString(cursor.getColumnIndex("TASK"))
                    tasks.add(task)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
            return tasks
        }

    companion object {
        // DatabaseHelper 클래스명 -> mydb
        // mydb.DATABASE_NAME -> 사용가능.
        const val DATABASE_NAME = "TodoDB.db" // 데이터베이스 명
        const val TABLE_NAME = "task" // 테이블 명

        // 테이블 항목
        const val COL_1 = "ID"
        const val COL_2 = "Task"
        const val COL_3 = "Taskdesc"
    }
}

