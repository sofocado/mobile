package com.example.restaurantapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.AccountViewPagerAdapter
import com.example.restaurantapp.fragments.AccountFragment

import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) {
            actionBar.hide()
        }
        setContentView(R.layout.activity_login)
        val viewPager: ViewPager = findViewById(R.id.view_pager1)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

// Create an instance of your ViewPager adapter
        val adapter = AccountViewPagerAdapter(supportFragmentManager)

// Set the adapter to the ViewPager
        viewPager.adapter = adapter

// Link the ViewPager with the TabLayout
        tabLayout.setupWithViewPager(viewPager)

        if (intent.getBooleanExtra("openLoginFragment", false)) {
            viewPager.currentItem = 0 // Switch to LoginFragment
        }
        if (intent.getBooleanExtra("openSignupFragment", false)) {
            viewPager.currentItem = 1 // Switch to LoginFragment
        }
    }
}