package com.example.restaurantapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.restaurantapp.fragments.Explain1Fragment
import com.example.restaurantapp.fragments.Explain2Fragment
import com.example.restaurantapp.fragments.Explain3Fragment


class ViewPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Explain1Fragment()
            1 -> Explain2Fragment()
            2 -> Explain3Fragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
