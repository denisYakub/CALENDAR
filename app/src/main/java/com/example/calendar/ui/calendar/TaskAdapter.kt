package com.example.calendar.ui.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.R

class RecyclerViewAdapter(listitems: List<String>, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val listItems: List<String> = listitems
    private val context:Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_in_tasklist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem: String = listItems[position]
        holder.task.text = listItem
        holder.switch.setOnClickListener {
            Toast.makeText(context, "Task ${position+1} done", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var task: TextView = itemView.findViewById<View>(R.id.taskView) as TextView
        var switch: CheckBox = itemView.findViewById(R.id.taskSwitch) as CheckBox
    }

}