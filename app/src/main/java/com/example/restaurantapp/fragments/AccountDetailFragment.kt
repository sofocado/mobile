package com.example.restaurantapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.R
import com.example.restaurantapp.viewmodels.RestaurantViewModel


class AccountDetailFragment : Fragment() {
    private lateinit var viewModel: RestaurantViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account_detail, container, false)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        val name = view.findViewById<EditText>(R.id.full_name)
        val phone = view.findViewById<EditText>(R.id.phone_number)

        viewModel.userDataLiveData.observe(viewLifecycleOwner) { userData ->
            // Extract "name" and "phone" columns from userData
            Log.i("jjjj", "jjjj")

            userData?.let { jsonObject ->
                val userObject = jsonObject.getAsJsonObject("user")
                val name = userObject?.get("name")?.asString
                val phone = userObject?.get("phoneNumber")?.asString

                    Log.i("jjjj", "jjjj")

                // Now you have access to the name and phone columns of userData
                // Use this data as needed in your fragment
            }
            // Now you have access to the name and phone columns of userData
            // You can use this data as needed in your fragment
        }

        return view
    }

}