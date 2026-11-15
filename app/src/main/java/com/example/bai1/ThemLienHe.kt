package com.example.bai1

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThemLienHe : AppCompatActivity() {
    val img_list = listOf<Int>(R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var edt1: EditText
        lateinit var edt2: EditText
        lateinit var edt3: EditText
        lateinit var edt4: EditText
        lateinit var rg1: RadioGroup
        lateinit var rb1: RadioButton
        lateinit var rb2: RadioButton
        lateinit var rb3: RadioButton
        lateinit var btnAdd: Button



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_them_lien_he)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        edt3 = findViewById(R.id.edt3)
        edt4 = findViewById(R.id.edt4)
        rg1 = findViewById(R.id.rg1)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val t1 = edt1.text.toString()
            val t2 = edt2.text.toString()
            val t3 = edt3.text.toString()
            val t4 = edt4.text.toString()
            val t5 = if(rb1.isChecked) "Nam" else if(rb2.isChecked) "Nu" else "Khac"
            val myDatabase = LienHeDB(this, "LienHe", 1)
            val db = myDatabase.writableDatabase

            val randomIcon = img_list.random()
            val contentValues = ContentValues()
            contentValues.put("icon", randomIcon)
            contentValues.put("name", t1)
            contentValues.put("sdt", t2)
            contentValues.put("email", t3)
            contentValues.put("diachi", t4)

            val k = db.insert("LienHe", null, contentValues)
            if(k>0){
                val item = LienHe_ItemInfo(randomIcon, t1, t2, t3, t4)
                LienHeList.add(item)
                finish() // -> ket thuc 1 activity
            }
            else{
                Toast.makeText(this, "Them that bai", Toast.LENGTH_SHORT).show()
            }

            db.close()

        }


    }
}