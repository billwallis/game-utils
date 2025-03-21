package com.example.gameutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_dice)

        val rollButton = findViewById<Button>(R.id.btnRollDie)
        val resultsTextView = findViewById<TextView>(R.id.tvDieResult)
        rollButton.setOnClickListener {
            // 'Simple' implementation
//            resultsTextView.text = Die().roll().toString()

            // Nicer UI
            Thread {
                for (i in 1..30) {
                    runOnUiThread {
                        resultsTextView.text = Die().roll().toString()
                    }
                    val sleepTime: Long = if (i < 20) 32 else 2.0.pow(i / 3.0 - 1.0).toLong()
                    Thread.sleep(sleepTime)
                }
            }.start()
        }
    }
}