package com.example.restaurantapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.restaurantapp.R
import com.example.restaurantapp.activities.ExplanaitionActivity
import com.example.restaurantapp.activities.MainActivity


class Explain3Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_explain3, container, false)
        val btn  = view.findViewById<AppCompatButton>(R.id.next_page)
        btn.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}