package com.example.bai1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var edUsername: EditText
    lateinit var edPassnanme: EditText
    lateinit var btnLogin: Button
    lateinit var tvRegist: TextView

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex_linear)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){
            view, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        edUsername = findViewById(R.id.txt1)
        edPassnanme = findViewById(R.id.txt2)
        btnLogin = findViewById(R.id.btn1)
        tvRegist = findViewById(R.id.txtview)

        btnLogin.setOnClickListener {
            val t1 = edUsername.text.toString()
            val t2 = edPassnanme.text.toString()
            if (t1 == "admin" && t2 == "123") {
                Toast.makeText(this,
                    "Login success",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                edUsername.setText("")
                edPassnanme.setText("")
                Toast.makeText(this,
                    "Login fail",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        edPassnanme.addTextChangedListener{
            val t = it.toString()
            if(t.length<8){
                tvRegist.setTextColor(R.color.red)
                tvRegist.text = "Mat khau ngan qua!"
            }
            else{
                tvRegist.setTextColor(R.color.black)
                tvRegist.text = "Mat khau dung!"
            }
        }


        }

}
