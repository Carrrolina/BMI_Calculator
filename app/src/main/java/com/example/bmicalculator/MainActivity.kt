package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edittext_weight)
        val edtHeight: EditText = findViewById(R.id.edittext_height)

        btnCalculate.setOnClickListener {

        val heightStr = edtHeight.text.toString()
        val weightStr = edtWeight.text.toString()

        if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
            val height: Float = heightStr.toFloat()
            val weight: Float = weightStr.toFloat()

            val finalHeight: Float = height * height
            val result: Float = weight / finalHeight

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)

        } else {
            Toast.makeText(this, "Fill in all fields", Toast.LENGTH_LONG).show()
        }
        }
    }
}