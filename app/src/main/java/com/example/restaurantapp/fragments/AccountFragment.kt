package com.example.restaurantapp.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R
import com.example.restaurantapp.activities.LoginActivity


class AccountFragment : Fragment() {
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        view.findViewById<AppCompatButton>(R.id.sign_up).setOnClickListener {

            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.putExtra("openSignupFragment", true)
            startActivity(intent)
        }

        view.findViewById<AppCompatButton>(R.id.log_in).setOnClickListener {
            // Set the current item to the index of the LoginFragment
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.putExtra("openLoginFragment", true)
            startActivity(intent)
        }
        return view
    }


}