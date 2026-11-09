package com.example.bai1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UnscrambleActivity : AppCompatActivity() {
    var level = 0
    var score = 0
    lateinit var tvLeve: TextView
    lateinit var tvScore: TextView
    lateinit var tvQuestion: TextView
    lateinit var btnSubmit: androidx.appcompat.widget.AppCompatButton
    lateinit var btnSkip: androidx.appcompat.widget.AppCompatButton
    lateinit var edAnswer: androidx.appcompat.widget.AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.unscramble)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvLeve = findViewById(R.id.tvLevel)
        tvScore = findViewById(R.id.tvScore)
        tvQuestion = findViewById(R.id.tvWord)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSkip = findViewById(R.id.btnSkip)
        edAnswer = findViewById(R.id.edText)
        val t = list[level].toList().shuffled().joinToString("")
        tvQuestion.text = t
        tvLeve.text = "${level + 1}/10"
        tvScore.text = "Score: $score"

        btnSubmit.setOnClickListener {
            var t1 = edAnswer.text.toString()
            t1 = t1.trim()
            if (t1 == list[level]) {
                level++
                tvLeve.text = "${level + 1}/10"
                edAnswer.setText("")
                val t = list[level].toList().shuffled().joinToString("")
                tvQuestion.text = t
            }else{
                score--
                tvScore.text = "Score: $score"
                edAnswer.setText("")
            }

        }

    }

}

val list = listOf("sing", "black", "write", "eat", "sleep", "sea")