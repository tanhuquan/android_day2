package com.example.bai1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LienHeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iconImg: ImageView = itemView.findViewById(R.id.iconImg)
    val tv_ten: TextView = itemView.findViewById(R.id.tv_ten)
    val tv_sdt: TextView = itemView.findViewById(R.id.tv_sdt)
    val tv_email: TextView = itemView.findViewById(R.id.tv_email)
    val tv_diachi: TextView = itemView.findViewById(R.id.tv_diachi)
    val call: TextView = itemView.findViewById(R.id.call)
    val sms: TextView = itemView.findViewById(R.id.sms)
}