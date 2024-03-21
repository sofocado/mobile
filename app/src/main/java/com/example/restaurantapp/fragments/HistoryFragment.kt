package com.example.restaurantapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.AccountViewPagerAdapter
import com.example.restaurantapp.adapters.HistoryViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_history, container, false)


        val viewPager: ViewPager = view.findViewById(R.id.view_pager1)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        val adapter = HistoryViewPagerAdapter(childFragmentManager)

// Set the adapter to the ViewPager
        viewPager.adapter = adapter

// Link the ViewPager with the TabLayout
        tabLayout.setupWithViewPager(viewPager)
        return view

    }


}