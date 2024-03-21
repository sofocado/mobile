package com.example.restaurantapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.R
import com.example.restaurantapp.models.Row
import com.example.restaurantapp.adapters.RestaurantAdapter
import com.example.restaurantapp.viewmodels.RestaurantViewModel


class HomeFragment : Fragment(), RestaurantAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RestaurantAdapter
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.restaurant_all_recycle)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RestaurantAdapter(requireContext(), emptyList(), this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        viewModel.restaurantData.observe(viewLifecycleOwner, Observer { rows ->
            adapter.updateData(rows)
        })

        viewModel.login("87074109068", "123")

        //viewModel.fetchData()
        return view

    }



    override fun onItemClick(data: Row) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Pass data to the new fragment
        val newFragment = RestaurantDetailedFragment()

        val bundle = Bundle()
        // Put your object into the bundle
        bundle.putParcelable("data_key", data)
        newFragment.arguments = bundle

        fragmentTransaction.replace(R.id.frame_main, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }



}


