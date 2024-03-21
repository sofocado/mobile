package com.example.restaurantapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.restaurantapp.R

class CustomSpinnerAdapter(context: Context, private val defaultIconResource: Int, private val values: Array<String>) :
    ArrayAdapter<String>(context, -1, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.spinner_item_layout, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.text)
        textView.text = values[position]

        val iconView = rowView.findViewById<ImageView>(R.id.icon)
        iconView.setImageResource(defaultIconResource)

        return rowView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}
