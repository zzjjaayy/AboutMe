package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * NOTE: THIS COMMIT HAS IMPLEMENTED DATA BINDING W/ A DATA CLASS.
     * The data class is called in the xml's data tag and values of TextViews are set from it.
     * Then an instance of the data class is made in the main activity where only the "nickname" is set
     * and the other one is just left to set as default.
     * the "name" is set from the edit text.
     */

    private lateinit var binding: ActivityMainBinding
    // this is a private variable initialised in onCreate

    private var myName:MyName = MyName(nickname = "Anything")
    //created an instance of the data class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // need to add this instead of just setContentView

        binding.jay = myName
        // calling the data in the XML and setting its value to a new instance of the "MyName" data class
        // this will bind the data to the views

        binding.doneButton.setOnClickListener {
            addName(it)
        }
        // the button is now called directly with the "binding" var.
    }

    private fun addName(view:View) {

        binding.apply {
            jay?.name = editName.text.toString()
            // setting the name parameter of the data in XML from the editText.
            invalidateAll()
            editName.visibility = View.GONE
            doneButton.visibility = View.GONE

            nameText.visibility = View.VISIBLE
        }
        // this is an "apply" fn which lets you in this case, call all view w/o the "binding" var.
        // all the views are directly called with the id given in the XML Layout
        // invalidateAll function invalidates all the view bindings and has to request a new one next time.

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        //will be explained later
    }

}