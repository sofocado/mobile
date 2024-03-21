package com.example.restaurantapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.RestaurantDetailedAdapter
import com.example.restaurantapp.models.Row
import com.google.android.material.tabs.TabLayout


class RestaurantDetailedFragment : Fragment() {


    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data: Parcelable? = arguments?.getParcelable("your_object_key")

        val view = inflater.inflate(R.layout.eeee, container, false)
        val receivedData: Row? = arguments?.getParcelable("data_key")

        val viewPager: ViewPager = view.findViewById(R.id.view_pager1)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)

// Create an instance of your ViewPager adapter
        val adapter = RestaurantDetailedAdapter(childFragmentManager)

// Set the adapter to the ViewPager
        viewPager.adapter = adapter

// Link the ViewPager with the TabLayout
        tabLayout.setupWithViewPager(viewPager)



        return view
    }

}