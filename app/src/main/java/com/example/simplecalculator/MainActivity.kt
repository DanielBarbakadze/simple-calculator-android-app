package com.example.simplecalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.buttonAdd)
        val btnSubtract: Button = findViewById(R.id.buttonSubtract)
        val btnMultiply: Button = findViewById(R.id.buttonMultiply)
        val btnDivide: Button = findViewById(R.id.buttonDivide)

        val firstVal: EditText = findViewById(R.id.editTextNumber1)
        val secondVal: EditText = findViewById(R.id.editTextNumber2)

        val handler: View.OnClickListener = View.OnClickListener { view ->
            if (firstVal.text.toString() == "" || secondVal.text.toString() == "") {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG)
                    .show()
            } else {
                var answer = 0
                val firstEnteredNumber: Int = firstVal.text.toString().toInt()
                val secondEnteredNumber: Int = secondVal.text.toString().toInt()
                var actionSign = ""
                when (view) {
                    btnAdd -> {
                        answer = firstEnteredNumber.plus(secondEnteredNumber);
                        actionSign = " + "
                    }
                    btnSubtract -> {
                        answer = firstEnteredNumber.minus(secondEnteredNumber);
                        actionSign = " - "
                    }
                    btnMultiply -> {
                        answer = firstEnteredNumber.times(secondEnteredNumber);
                        actionSign = " * "
                    }
                    btnDivide -> {
                        answer = firstEnteredNumber.div(secondEnteredNumber);
                        actionSign = " / "
                    }
                }
                val intent = Intent(this, AnswerActivity::class.java)
                intent.putExtra("firstVal", firstVal.text.toString())
                intent.putExtra("secondVal", secondVal.text.toString())
                intent.putExtra("actionSign", actionSign)
                intent.putExtra("answer", answer.toString())
                startActivity(intent)
            }
        }
        btnAdd.setOnClickListener(handler)
        btnSubtract.setOnClickListener(handler)
        btnMultiply.setOnClickListener(handler)
        btnDivide.setOnClickListener(handler)
    }
}