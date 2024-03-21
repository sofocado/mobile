package com.example.restaurantapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.restaurantapp.R
import com.example.restaurantapp.databinding.ActivityMainBinding
import com.example.restaurantapp.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) {
            actionBar.hide()
        }

        replaceFragment(HomeFragment())
        val intent = Intent(this, ExplanaitionActivity::class.java)


        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> replaceFragment(HomeFragment())
                R.id.item_liked -> replaceFragment(LikedFragment())
                R.id.item_qr -> replaceFragment(AccountDetailFragment())
                R.id.item_account -> replaceFragment(AccountFragment())
                R.id.item_history -> replaceFragment(HistoryFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main, fragment)
            .addToBackStack(null) // Optional: This allows the user to navigate back to the previous fragment
            .commit()
    }
}