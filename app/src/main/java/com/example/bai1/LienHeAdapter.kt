package com.example.bai1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class LienHeAdapter(val context: ListLienHeActivity): RecyclerView.Adapter<LienHeHolder>() {
    //tao holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LienHeHolder {
        val lienheIteminfo = LayoutInflater.from(context).inflate(R.layout.lien_he_layout, parent, false)
        return LienHeHolder(lienheIteminfo)
    }

    override fun onBindViewHolder(holder: LienHeHolder, position: Int) {
        val item = LienHeList[position]
        holder.iconImg.setImageResource(item.icon)
        holder.tv_ten.text = item.name
        holder.tv_sdt.text = item.sdt
        holder.tv_email.text = item.email
        holder.tv_diachi.text = item.diachi
        holder.itemView.setOnLongClickListener {
            val myDatabase = LienHeDB(context, "LienHe", 1)
            val db = myDatabase.writableDatabase
            val k = db.delete("LienHe", "name = ?", arrayOf(item.name))
            if(k>0){
                LienHeList.removeAt(position)
                context.adapter.notifyDataSetChanged()
                Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show()
            }


            true
        }
    }

    override fun getItemCount(): Int {
        return LienHeList.size
    }

}