package com.example.bai1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: ListActivity) : RecyclerView.Adapter<MyHolder>() {
    //tao myholder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.ex_frame, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = MyList[position]
        holder.imgIcon.setImageResource(item.icon)
        holder.txt1.text = item.name
        holder.checkbox.isChecked = item.selection

        holder.itemView.setOnLongClickListener {
            val myDatabase = MyDatabase(context, "Friend", 1)
            val db = myDatabase.writableDatabase
            val k = db.delete("Friend", "name = ?", arrayOf(item.name))
            if(k>0){
                MyList.removeAt(position)
                context.adapter.notifyDataSetChanged()
                Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show()
            }
            db.close()

            true
        }
    }

    override fun getItemCount(): Int {
        return MyList.size
    }
}