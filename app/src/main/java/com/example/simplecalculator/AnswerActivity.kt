package com.example.simplecalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.StringBuilder

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val textAnswer: TextView = findViewById(R.id.answerText)
        textAnswer.text = StringBuilder()
            .append(intent.getStringExtra("firstVal"))
            .append(intent.getStringExtra("actionSign"))
            .append(intent.getStringExtra("secondVal"))
            .append(" = ")
            .append(intent.getStringExtra("answer"))

        val goBack: ConstraintLayout = findViewById(R.id.answerLayout)
        val handler: View.OnClickListener = View.OnClickListener {
            finish();
        }
        goBack.setOnClickListener(handler)


    }

}