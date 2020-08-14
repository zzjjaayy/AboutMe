package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // this is a private variable initialised in onCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // need to add this instead of just setContentView

        binding.doneButton.setOnClickListener {
            addName(it)
        }
        // the button is now called directly with the "binding" var.
    }

    private fun addName(view:View) {

        binding.apply {
            nameText.text = editName.text
            invalidateAll()
            editName.visibility = View.GONE
            doneButton.visibility = View.GONE

            nameText.visibility = View.VISIBLE
        }
        // this is an "apply" fn which lets you in this case, call all view w/o the "binding" var.
        // all the views are directly called with the id given in the XML Layout
        // invalidateAll function clears the data in the views.

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        //will be explained later
    }

}