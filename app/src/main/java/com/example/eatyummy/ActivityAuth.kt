package com.example.eatyummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class ActivityAuth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val btnStarter = findViewById<Button>(R.id.btnStarter)
        val etAuthPhone = findViewById<EditText>(R.id.etAuthPhone)
        btnStarter.setOnClickListener {
            ActivityOrdersList.newInstance(
                activity = this,
                phoneNumber = etAuthPhone.text.toString())
        }
    }
}