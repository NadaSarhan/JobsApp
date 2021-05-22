package com.nada.jobsapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nada.jobsapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)

        btnStart.setOnClickListener {
            //intent to start activity
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }

    }

}