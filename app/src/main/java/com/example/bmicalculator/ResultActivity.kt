package com.example.bmicalculator

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5f) {
            "Underweight"
        } else if (result in 18.5f..25f) {
            "Normal (healthy weight)"
        } else if (result in 25f..30f) {
            "Overweight"
        } else if (result in 30f..35f) {
            "Moderately obese (Class I)"
        } else if (result in 35f..40f) {
            "Severely obese (Class II)"
        } else {
            "Very severely obese (Class III)"
        }

        tvClassification.text = getString(R.string.message_classification,classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}