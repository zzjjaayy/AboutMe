package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.doneButton).setOnClickListener {
            addName(it)
        }
        // calls a click listener directly on the button and calling the click handler inside the lambda fn.
    }

    private fun addName(view:View) {
        val editText = findViewById<EditText>(R.id.editName)
        val nameText = findViewById<TextView>(R.id.nameText)

        nameText.text = editText.text
        // sets the nameText value to edit text input
        view.visibility = View.GONE
        editText.visibility = View.GONE
        // hide the button and edit text field
        nameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        //will be explained later
    }

}