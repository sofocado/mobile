package com.example.restaurantapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R


class Explain2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_explain2, container, false)
        val btn  = view.findViewById<AppCompatButton>(R.id.next_page)
        btn.setOnClickListener {
            // Access parent activity
            val activity = requireActivity()

            // Find the ViewPager
            val viewPager = activity.findViewById<ViewPager>(R.id.view_pager)

            // Get the current item and move to the next one
            viewPager.currentItem = viewPager.currentItem + 1
        }
        return view
    }


}