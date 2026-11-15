package com.example.bai1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LienHeDB(context: Context, name: String, version: Int): SQLiteOpenHelper(context, name, null, version){
    override fun onCreate(db: SQLiteDatabase?) {
        createTable(db)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        createTable(db)
    }

    private fun createTable(db: SQLiteDatabase?) {
        val sql = "create table if not exists LienHe(" + "icon integer," + "name text primary key," + "sdt text," + "email text," + "diachi text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS LienHe")
        onCreate(db)
    }

}