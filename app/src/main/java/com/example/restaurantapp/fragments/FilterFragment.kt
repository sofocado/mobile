package com.example.restaurantapp.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.restaurantapp.R
import com.example.restaurantapp.adapters.CustomSpinnerAdapter
import com.google.android.material.button.MaterialButton


class FilterFragment : Fragment() {
    private lateinit var viewFragment: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewFragment = inflater.inflate(com.example.restaurantapp.R.layout.fragment_filter, container, false)

        val cancel = viewFragment.findViewById<TextView>(R.id.cancel)
        val clear_all = viewFragment.findViewById<TextView>(R.id.clear_all)


        val btn = viewFragment.findViewById<AppCompatButton>(R.id.distance)
        val btn1 = viewFragment.findViewById<AppCompatButton>(R.id.rating)

        val spinner = setUpSpinner(com.example.restaurantapp.R.id.spinner1, com.example.restaurantapp.R.array.spinner_items1, com.example.restaurantapp.R.drawable.price)
        val spinner1 = setUpSpinner(com.example.restaurantapp.R.id.spinner2, com.example.restaurantapp.R.array.spinner_items1, R.drawable.cuisines)
        val spinner2 = setUpSpinner(R.id.spinner3, R.array.spinner_items1, R.drawable.and)

        val checkedTextView1 = setUpCheckedTextView(R.id.checkedTextView1)
        val checkedTextView2 = setUpCheckedTextView(R.id.checkedTextView2)

        setCheckedTextViewClickListener(checkedTextView1)
        setCheckedTextViewClickListener(checkedTextView2)

        val frameLayout2 = viewFragment.findViewById<FrameLayout>(R.id.frameLayout2)
        val frameLayout = viewFragment.findViewById<FrameLayout>(R.id.frameLayout1)
        val frameLayout3 = viewFragment.findViewById<FrameLayout>(R.id.frameLayout)


        val img = viewFragment.findViewById<ImageView>(R.id.img)
        val img1 = viewFragment.findViewById<ImageView>(R.id.img1)
        val img2 = viewFragment.findViewById<ImageView>(R.id.img2)


        val txt = viewFragment.findViewById<TextView>(R.id.txt)
        val txt1 = viewFragment.findViewById<TextView>(R.id.txt1)
        val txt2 = viewFragment.findViewById<TextView>(R.id.txt2)

        val buttons = mutableListOf<AppCompatButton>()
        val autoButton = viewFragment.findViewById<AppCompatButton>(R.id.auto)
        val button1 = viewFragment.findViewById<AppCompatButton>(R.id.btn1)
        val button2 = viewFragment.findViewById<AppCompatButton>(R.id.btn2)
        val button3 = viewFragment.findViewById<AppCompatButton>(R.id.btn3)
        val button4 = viewFragment.findViewById<AppCompatButton>(R.id.btn4)
        val button5 = viewFragment.findViewById<AppCompatButton>(R.id.btn5)


        buttons.add(autoButton)
        buttons.add(button1)
        buttons.add(button2)
        buttons.add(button3)
        buttons.add(button4)
        buttons.add(button5)



        clear_all.setOnClickListener {
            val currentFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.frame_main)
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            // Check if the current fragment is the one you want to update
            if (currentFragment is FilterFragment) {
                // Perform the update on the current fragment
                fragmentTransaction.replace(R.id.frame_main, FilterFragment())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

        for (button in buttons) {
            button.setOnClickListener {
                // Clear selection for all buttons
                for (btn in buttons) {
                    btn.isSelected = false
                    btn.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.white)
                    btn.setTextColor(ContextCompat.getColor(requireContext(), R.color.green_2))

                }

                // Set the selected button
                it.isSelected = true
                it.background = ContextCompat.getDrawable(requireContext(), R.drawable.small_rounded)
                it.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.green_2)
                button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            }
        }



        btn.setOnClickListener {
            changeButtonColor(btn, requireContext())
        }

        btn1.setOnClickListener {
            changeButtonColor(btn1, requireContext())
        }

        frameLayout2.setOnClickListener {
            handleFrameLayoutClick(frameLayout2, img, txt)
        }

        frameLayout.setOnClickListener {
            handleFrameLayoutClick(frameLayout, img1, txt1)
        }

        frameLayout3.setOnClickListener {
            handleFrameLayoutClick(frameLayout3, img2, txt2)
        }

        return viewFragment
    }

    fun changeButtonColor(button: AppCompatButton, context: Context) {
        // Change color when clicked
        val colorClicked = ContextCompat.getColor(context, R.color.green_2)
        val colorUnclicked = Color.WHITE

        val textColorClicked = Color.WHITE
        val textColorUnclicked = ContextCompat.getColor(context, R.color.green_2)

        val currentColor = if (button.isSelected) colorUnclicked else colorClicked
        val currentTextColor = if (button.isSelected) textColorUnclicked else textColorClicked

        // Change background tint based on the current state
        button.backgroundTintList = ColorStateList.valueOf(currentColor)

        // Change text color based on the current state
        button.setTextColor(currentTextColor)

        // Toggle button state
        button.isSelected = !button.isSelected
    }

    private fun setUpSpinner(spinnerId: Int, itemsArrayId: Int, drawableId: Int): Spinner {
        val spinner = viewFragment.findViewById<Spinner>(spinnerId)
        val items = requireContext().resources.getStringArray(itemsArrayId)
        val adapter = CustomSpinnerAdapter(requireContext(), drawableId, items)
        spinner.adapter = adapter
        return spinner
    }

    private fun setUpCheckedTextView(checkedTextViewId: Int): CheckedTextView {
        return viewFragment.findViewById<CheckedTextView>(checkedTextViewId)
    }

    private fun setCheckedTextViewClickListener(checkedTextView: CheckedTextView) {
        checkedTextView.setOnClickListener {
            checkedTextView.isChecked = !checkedTextView.isChecked
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun handleFrameLayoutClick(frameLayout: FrameLayout, imageView: ImageView, textView: TextView) {


        if (frameLayout.isSelected) {
            // Already selected, deselect it
            val color = ContextCompat.getColor(context!!, com.example.restaurantapp.R.color.green_2)

            frameLayout.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            imageView.setColorFilter(color) // Change ImageView color to black
            textView.setTextColor(color)
            frameLayout.isSelected = false
        } else {
            // Not selected, select it
            val color = ContextCompat.getColor(context!!, com.example.restaurantapp.R.color.green_2)
            frameLayout.backgroundTintList = ColorStateList.valueOf(color)
            imageView.setColorFilter(Color.WHITE) // Change ImageView color to black
            textView.setTextColor(Color.WHITE)
            frameLayout.isSelected = true
        }

    }
}
