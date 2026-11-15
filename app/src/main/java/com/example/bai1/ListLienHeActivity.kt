package com.example.bai1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager

class ListLienHeActivity : AppCompatActivity() {
    lateinit var rcv: androidx.recyclerview.widget.RecyclerView
    lateinit var adapter: LienHeAdapter
    lateinit var btnAdd : Button
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_lien_he)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        LienHeList.clear()
        val myDatabase = LienHeDB(this, "LienHe", 1)
        val db = myDatabase.readableDatabase
        try {
            val pointer = db.rawQuery("select * from LienHe", null)
            while(pointer.moveToNext()){
                val t1 = pointer.getInt(0)
                val t2 = pointer.getString(1)
                val t3 = pointer.getString(2)
                val t4 = pointer.getString(3)
                val t5 = pointer.getString(4)
                val item = LienHe_ItemInfo(t1, t2, t3, t4, t5)
                LienHeList.add(item)
            }
            pointer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db.close()
        }


        rcv = findViewById(R.id.rcv)
        adapter = LienHeAdapter(this)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = adapter

        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val intent = Intent(this, ThemLienHe::class.java)
            startActivity(intent)
        }


    }
    override fun onRestart() {
        super.onRestart()
        adapter.notifyDataSetChanged()
    }


}