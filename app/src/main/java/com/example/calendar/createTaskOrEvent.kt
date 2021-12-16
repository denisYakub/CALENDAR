package com.example.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.R.layout
import android.accessibilityservice.GestureDescription
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Build

import android.widget.TimePicker

import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog


class createTaskOrEvent : AppCompatActivity(){

    val types:Array<String> = arrayOf("select type","task","event")
    val importance:Array<String> = arrayOf("select importance","Can wait", "Urgent", "Important")
    val remember:Array<String> = arrayOf("select when to remember", "when it begins", "10 min before", "30 min before",
        "1 hour before", "12 hours before", "1 day before", "1 week before")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task_or_event)
        val typeAa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, types)
        var typeSpinner = findViewById<Spinner>(R.id.typeSpinner)
        typeSpinner.adapter = typeAa
        typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val importanceAa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, importance)
        var importanceSpinner = findViewById<Spinner>(R.id.importanceSpinner)
        importanceSpinner.adapter = importanceAa
        importanceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val rememberAa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, remember)
        var rememberSpinner = findViewById<Spinner>(R.id.notifyBeforeSpinner)
        rememberSpinner.adapter = rememberAa
        rememberSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onDateClick(view: android.view.View) {
        val dialogView = View.inflate(this, R.layout.date_time_picker, null)
        val alertDialog: AlertDialog = AlertDialog.Builder(this).create()

        dialogView.findViewById<View>(R.id.date_time_set).setOnClickListener {
            val datePicker = dialogView.findViewById<View>(R.id.date_picker) as DatePicker
            val timePicker = dialogView.findViewById<View>(R.id.time_picker) as TimePicker
            val calendar: Calendar = GregorianCalendar(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth,
                timePicker.currentHour,
                timePicker.currentMinute
            )
           // time = calendar.getTimeInMillis()
            alertDialog.dismiss()
        }
        alertDialog.setView(dialogView)
        alertDialog.show()
    }
}