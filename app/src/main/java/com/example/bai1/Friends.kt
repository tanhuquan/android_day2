package com.example.bai1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Friend")
class Friends(
    var icon: Int,
    @PrimaryKey var name: String,
    var status: Boolean
) {


}