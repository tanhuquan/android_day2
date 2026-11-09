package com.example.bai1

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class AddFriendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var edt1: EditText
        lateinit var edt2: EditText
        lateinit var btn1: Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_friend)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {
            val t1 = edt1.text.toString()
            val t2 = edt2.text.toString()

            val myDatabase = MyDatabase(this, "Friend", 1)
            val db = myDatabase.writableDatabase

            val contentValues = ContentValues()
            contentValues.put("icon",  R.drawable.img_4)
            contentValues.put("name", t1)
            contentValues.put("status", t2.toBoolean())

            val k = db.insert("Friend", null, contentValues)
            if(k>0){
                val item = ItemInfo(R.drawable.img_4, t1, t2.toBoolean())
                MyList.add(item)
                finish() // -> ket thuc 1 activity
            }
            else{
                Toast.makeText(this, "Them that bai", Toast.LENGTH_SHORT).show()
            }
            db.close()


        }
    }
}