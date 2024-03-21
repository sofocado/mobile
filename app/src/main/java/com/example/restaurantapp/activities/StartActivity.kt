package com.example.restaurantapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatButton
import com.example.restaurantapp.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) {
            actionBar.hide()
        }
        val btn = findViewById<AppCompatButton>(R.id.next_page)
        btn.setOnClickListener {
            // Define the intent for the next activity
            val intent = Intent(this, ExplanaitionActivity::class.java)

            // Start the next activity
            startActivity(intent)
        }
    }
}