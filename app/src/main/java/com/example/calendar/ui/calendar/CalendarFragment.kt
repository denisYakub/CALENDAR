package com.example.calendar.ui.calendar

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.calendar.R
import com.example.calendar.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.*
import android.widget.AdapterView
import android.widget.Toast
import com.google.android.material.navigation.NavigationBarView

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentCalendarBinding? = null
    private val monthDay2 = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28)
    private val monthDay1 = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30)
    private val monthDay = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    private val monthName = arrayOf("January", "February", "March", "April", "May", "June", "July", "August",
    "September", "October", "November", "December")
    private lateinit var t:TextView
    private lateinit var spin:Spinner
    private lateinit var g:GridView

    private lateinit var adaper:ArrayAdapter<Int>
    private lateinit var adaper2:ArrayAdapter<Int>
    private lateinit var adaper1:ArrayAdapter<Int>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCalendar(root: View, dateFormat: Int){
        spin = root.findViewById<Spinner>(R.id.spinner)
        when(dateFormat){
            1,3,5,7,8,10,12 -> {
                g = root.findViewById(R.id.days)
                t = root.findViewById(R.id.month)
                g.adapter = adaper
                t.text = monthName[dateFormat - 1]
                spin.setSelection(dateFormat - 1)
            }
            2 -> {
                g = root.findViewById(R.id.days)
                t = root.findViewById(R.id.month)
                g.adapter = adaper2
                t.text = monthName[dateFormat - 1]
                spin.setSelection(dateFormat - 1)
            }
            else -> {
                g = root.findViewById(R.id.days)
                t = root.findViewById(R.id.month)
                g.adapter = adaper1
                t.text = monthName[dateFormat - 1]
                spin.setSelection(dateFormat - 1)
            }
        }
    }
    private fun updateCalendar(root: View, month:Int){
        when(month){
            1,3,5,7,8,10,12 -> {
                adaper.clear()
                adaper.addAll(monthDay)
                adaper.notifyDataSetChanged()
            }
            2 -> {
                adaper2.clear()
                adaper2.addAll(monthDay2)
                adaper2.notifyDataSetChanged()
            }
            else -> {
                adaper1.clear()
                adaper1.addAll(monthDay1)
                adaper1.notifyDataSetChanged()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        spin = root.findViewById(R.id.spinner)
        val ad: ArrayAdapter<String> = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, monthName)
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = ad

        val dateFormat: Int = SimpleDateFormat("MM").format(Date()).toInt()
        adaper = ArrayAdapter(root.context, android.R.layout.simple_list_item_1, monthDay)
        adaper2 = ArrayAdapter(root.context, android.R.layout.simple_list_item_1, monthDay2)
        adaper1 = ArrayAdapter(root.context, android.R.layout.simple_list_item_1, monthDay1)
        setCalendar(root, dateFormat)
        g.onItemClickListener = OnItemClickListener { parent, v, position, id ->
            val bundle = Bundle()
            val fragment = DayFragment()
            bundle.putInt("day",position)
            fragment.arguments = bundle
            Navigation.findNavController(root).navigate(R.id.action_navigation_calendar_to_dayFragment, bundle)
        }
        spin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //updateCalendar(root, position+1)
            }

        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}