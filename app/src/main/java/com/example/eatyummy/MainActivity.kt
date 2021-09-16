package com.example.eatyummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.eatyummy.AuthFragment
import com.example.eatyummy.OrdersListFragment
import com.example.eatyummy.MainNavigation
import com.example.eatyummy.R

class MainActivity: AppCompatActivity(), MainNavigation {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         openAuthFragment()
    }

    override fun openAuthFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flRoot, AuthFragment())
            .commit()
    }

    override fun openOrdersListFragment(phoneNumber: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flRoot, OrdersListFragment.newInstance(phoneNumber = phoneNumber))
            .addToBackStack("OrdersListFragment")
            .commit()
    }
}
