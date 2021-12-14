package com.example.calendar.ui.calendar

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calendar.R
import com.example.calendar.databinding.FragmentCalendarBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import android.widget.AdapterView.OnItemClickListener
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.calendar.createTaskOrEvent
import org.jetbrains.annotations.Nullable


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentCalendarBinding? = null
    private val MonthDay2 = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28)
    private val MonthDay1 = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30)
    private val MonthDay = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    private val MonthName = arrayOf("January", "February", "March", "April", "May", "June", "July", "August",
    "September", "October", "November", "December")
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCalendar(root: View){
        val dateFormat: DateFormat = SimpleDateFormat("MM")
        val month = dateFormat.format(Date()).toInt()
        when(month){
            1,3,5,7,8,10,12 -> {
                val g:GridView = root.findViewById(R.id.days)
                val t:TextView = root.findViewById(R.id.month)
                val adaper:ArrayAdapter<Int> = ArrayAdapter(root.context, android.R.layout.simple_list_item_1,
                    MonthDay)
                g.adapter = adaper
                t.setText(MonthName[month-1])
            }
            2 -> {
                val g:GridView = root.findViewById(R.id.days)
                val t:TextView = root.findViewById(R.id.month)
                val adaper:ArrayAdapter<Int> = ArrayAdapter(root.context, android.R.layout.simple_list_item_1,
                    MonthDay2)
                g.adapter = adaper
                t.setText(MonthName[month-1])
            }
            else -> {
                val g:GridView = root.findViewById(R.id.days)
                val t:TextView = root.findViewById(R.id.month)
                val adaper:ArrayAdapter<Int> = ArrayAdapter(root.context, android.R.layout.simple_list_item_1,
                    MonthDay1)
                g.adapter = adaper
                t.setText(MonthName[month-1])
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setCalendar(root)
        val g:GridView = root.findViewById(R.id.days)
        g.onItemClickListener = OnItemClickListener { parent, v, position, id ->

            val bundle = Bundle()
            val fragment = DayFragment()
            bundle.putInt("day",position)
            fragment.arguments = bundle
            Navigation.findNavController(root).navigate(R.id.action_navigation_calendar_to_dayFragment, bundle)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}