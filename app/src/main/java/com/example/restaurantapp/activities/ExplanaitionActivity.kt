package com.example.restaurantapp.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.ViewPageAdapter


class ExplanaitionActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explanaition)

        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) {
            actionBar.hide()
        }
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = ViewPageAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }
}