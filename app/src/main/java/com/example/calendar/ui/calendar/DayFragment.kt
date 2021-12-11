package com.example.calendar.ui.calendar

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar.R
import androidx.recyclerview.widget.RecyclerView

class DayFragment: Fragment(R.layout.fragment_day){
    private val arr: ArrayList<String> = arrayListOf("Сделать лабу", "Сделать курсовую",
        "Досмотреть сериал", "Почитать книгу")
    private var progress:Int = 0
    private fun setItemRecyclerViewAdapter(view: View, arr: ArrayList<String>){
        val recyclerView = view.findViewById<RecyclerView>(R.id.TaskList)
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(view.context);
        val recyclerViewAdapter = RecyclerViewAdapter(arr, view.context)
        recyclerView.adapter = recyclerViewAdapter
    }
    private fun setDate(view: View){
        val bun: Bundle? = this.arguments
        val date = bun?.getInt("day")
        view.findViewById<TextView>(R.id.Date).text = date.toString()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDate(view)
        setItemRecyclerViewAdapter(view, arr)
        val prBar = view.findViewById<ProgressBar>(R.id.progressBar)
        prBar.max = arr.size
        prBar.progress = progress
        /*view.findViewById<Switch>(R.id.taskSwitch).setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                prBar.progress = progress++
            }else{
                prBar.progress = progress--
            }
        view.findViewById<Switch>(R.id.taskSwitch).setOnClickListener {
            prBar.progress = progress++
        }*/

    }
}