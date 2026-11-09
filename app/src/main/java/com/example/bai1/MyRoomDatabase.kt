package com.example.bai1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Friends::class], version = 1)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDAO
}