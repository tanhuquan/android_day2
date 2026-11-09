package com.example.bai1

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imgIcon: ImageView = itemView.findViewById(R.id.imgIcon)
    val txt1: TextView = itemView.findViewById(R.id.txt1)
    val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)


}