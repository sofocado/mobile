package com.example.restaurantapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.MoreInfoAdapter
import com.example.restaurantapp.models.InfoItem


class MoreInformationFragment :  DialogFragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity(), R.style.CustomDialogStyle)
        val inflater = requireActivity().layoutInflater

        val view = inflater.inflate(R.layout.fragment_more_information, null)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val informationItems = listOf(
            InfoItem("Phone", "8 777 777 77 77", R.drawable.phone),
            InfoItem("Average", "10000 tg", R.drawable.check),
            InfoItem("Cuisine", "International, Italian", R.drawable.cuisine),
            InfoItem("Parking", "Available", R.drawable.parking),
            InfoItem("Praying room", "None", R.drawable.pray)
        )

        recyclerView.adapter = MoreInfoAdapter(informationItems)

        builder.setView(view)

        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            dismiss() // Dismiss the dialog when cancel button is clicked
        }
        return builder.create()


    }
}