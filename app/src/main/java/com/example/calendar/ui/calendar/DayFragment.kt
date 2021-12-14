package com.example.calendar.ui.calendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar.R
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent.getIntent
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class DayFragment: Fragment(R.layout.fragment_day){
    private val arr: ArrayList<String> = arrayListOf("Сделать лабу", "Сделать курсовую",
        "Досмотреть сериал", "Почитать книгу")
    private var progress:Int = 0
    private fun setDay(view: View){
        val date = this.arguments?.getInt("day")?.plus(1).toString()
        val dateFormat: DateFormat = SimpleDateFormat("MM.yyyy")
        val month = dateFormat.format(Date())
        val fullDate = date + "." + month
        view.findViewById<TextView>(R.id.Date).text = fullDate
    }
    private fun setTaskList(arr:ArrayList<String>, view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.TaskList)
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(view.context);
        val recyclerViewAdapter = RecyclerViewAdapter(arr, view.context)
        recyclerView.adapter = recyclerViewAdapter
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDay(view)
        setTaskList(arr, view)
    }
}

