package com.example.eatyummy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityOrdersList : AppCompatActivity() {

    companion object {
        const val PHONE_NUMBER_KEY = "PHONE_NUMBER"

        fun newInstance(activity: ActivityAuth, phoneNumber: String) {
            val intent = Intent(activity, ActivityOrdersList::class.java).apply {
                putExtra(PHONE_NUMBER_KEY, phoneNumber)
            }
            activity.startActivity(intent)
        }
    }

    var phoneNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_list)
        getPhoneNumberFromExtra()
        val tvPhoneNumber = findViewById<TextView>(R.id.tvPhoneNumber)
        tvPhoneNumber.text = "Phone number: $phoneNumber"
    }

    private fun getPhoneNumberFromExtra() {
        phoneNumber = intent.getStringExtra(PHONE_NUMBER_KEY) ?: ""
    }
}