package com.example.restaurantapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.R
import com.example.restaurantapp.models.Row
import com.example.restaurantapp.fragments.HomeFragment

class RestaurantAdapter(private val context: Context, private var dataList: List<Row>, private val itemClickListener: HomeFragment) : RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {
    interface OnItemClickListener {

        fun onItemClick(data: Row)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_restaurant_upcoming, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind data to views in ViewHolder
        val currentItem = dataList[position]
        holder.textView.text = currentItem.name

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(currentItem)
        }

        // Use currentItem to set data to views in ViewHolder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views here using itemView.findViewById()
        val textView: TextView = itemView.findViewById(R.id.name)

    }
    fun updateData(newRows: List<Row>) {
        dataList = newRows
        notifyDataSetChanged()
    }
}