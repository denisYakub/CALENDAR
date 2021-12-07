package com.example.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Spinner

class createTaskOrEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task_or_event)
       /* var type = findViewById<Spinner>(R.id.typeSpinner)
        val typeList = mutableListOf<String>("Task","Event")
        val aa = ArrayAdapter(this,android.R.layout.simple_spinner_item,typeList)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        type!!.adapter = aa
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_first, container, false)*/
    }
}