package com.example.eatyummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.eatyummy.databinding.FragmentAuthorizationBinding

class AuthFragment: Fragment() {

    private lateinit var binging: FragmentAuthorizationBinding

    companion object {
        const val COUNT_OF_NUMBERS_IN_RUS_PHONE = 10
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binging = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binging.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureStartButton()
        configurePhoneField()
    }

    private fun configureStartButton() {
        binging.btnStarter.setOnClickListener {
            (activity as? MainNavigation)?.openOrdersListFragment(binging.etAuthPhone.text.toString())
        }
    }

    private fun configurePhoneField() {
        binging.etAuthPhone.doOnTextChanged { text, _, _, _ ->
            binging.btnStarter.isEnabled = text?.length!! > COUNT_OF_NUMBERS_IN_RUS_PHONE
        }
    }
}