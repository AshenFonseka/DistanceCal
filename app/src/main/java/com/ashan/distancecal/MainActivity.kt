package com.ashan.distancecal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val miles: EditText by lazy { findViewById<EditText>(R.id.miles) }
    private val inches: EditText by lazy { findViewById<EditText>(R.id.inchs) }
    private val feet: EditText by lazy { findViewById<EditText>(R.id.feet) }
    private val button: Button by lazy { findViewById<Button>(R.id.button) }
    private val answer: TextView  by lazy { findViewById<TextView>(R.id.answer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { calculate() }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        calculate()

    }

    private fun calculate() {
        val convertedMilesInM: Double = miles.text.toString().ifEmpty { "0" }.toFloat() * 1609.34
        val convertedInchInM: Double = inches.text.toString().toFloat() * 0.0254
        val convertedFeetInM: Double = feet.text.toString().toFloat() * 0.3048
        val totalInM: Double = convertedInchInM + convertedMilesInM + convertedFeetInM

        answer.text = ("$totalInM cm")
    }
}
