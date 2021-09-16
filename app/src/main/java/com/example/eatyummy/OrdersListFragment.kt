package com.example.eatyummy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class OrdersListFragment: Fragment() {

    companion object {
        private const val PHONE_NUMBER_KEY = "PHONE_NUMBER"

        fun newInstance(phoneNumber: String):  OrdersListFragment {
            return OrdersListFragment().apply {
                arguments = bundleOf(
                    PHONE_NUMBER_KEY to phoneNumber)
            }
        }
    }

    var phoneNumber: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_orders_list, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPhoneNumberFromArguments()
        val tvPhoneNumber = view.findViewById<TextView>(R.id.tvPhoneNumber)
        tvPhoneNumber.text = "Phone number: $phoneNumber"
    }

    private fun getPhoneNumberFromArguments() {
        phoneNumber = arguments?.getString(PHONE_NUMBER_KEY)
    }
}