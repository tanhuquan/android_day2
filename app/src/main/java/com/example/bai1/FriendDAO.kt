package com.example.bai1

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FriendDAO {
    @Query("select * from Friend")
    fun getAll(): List<Friends>
    fun insert(friend: Friends)
    fun delete(friend: Friends)
    fun update(friend: Friends)
}