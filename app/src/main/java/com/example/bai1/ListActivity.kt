package com.example.bai1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager

class ListActivity : AppCompatActivity() {
    lateinit var rcv: androidx.recyclerview.widget.RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var btnAdd : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        MyList.clear()
        val myDatabase = MyDatabase(this, "Friend", 1)
        val db = myDatabase.readableDatabase
        val pointer = db.rawQuery("select * from Friend", null)
        while(pointer.moveToNext()){
            val t1 = pointer.getInt(0)
            val t2 = pointer.getString(1)
            val t3 = pointer.getInt(2)==0
            val item = ItemInfo(t1, t2, t3)
            MyList.add(item)
        }

        pointer.close()
        db.close()


        btnAdd = findViewById(R.id.btnAdd)
        rcv = findViewById(R.id.rcv)
        adapter = MyAdapter(this)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = adapter


        btnAdd.setOnClickListener {
            val intent = Intent(this, AddFriendActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        adapter.notifyDataSetChanged()
    }
}