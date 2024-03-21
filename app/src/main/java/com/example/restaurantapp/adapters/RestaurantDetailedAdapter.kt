package com.example.restaurantapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.restaurantapp.fragments.LogInFragment
import com.example.restaurantapp.fragments.OverviewFragment
import com.example.restaurantapp.fragments.ReviewFragment
import com.example.restaurantapp.fragments.SignUpFragment

class RestaurantDetailedAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment() // Your First Fragment
            1 -> ReviewFragment() // Your Second Fragment
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun getCount(): Int {
        return 2 // Number of fragments
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            1 -> "Overviews" // Title for the first tab
            0 -> "Reviews" // Title for the second tab
            else -> null
        }
    }
}