package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.employeetaskadapter
import com.tupleinfotech.officeproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding?= null
    private val binding get() =  _binding!!

    private lateinit var tasklistitem: List<employeetasklistitems>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root

        tasklist()
        return view
    }


    private fun tasklist(){
        tasklistitem= listOf(
            employeetasklistitems("My Tasks","99"),
            employeetasklistitems("Noticeboard","99"),
            employeetasklistitems("Monthly Report","99"),
            employeetasklistitems("Holiday list","99"),
        )

        val recyclerviewitemlist = binding.rv
        val layoutManager = GridLayoutManager(requireActivity(), 2)

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = employeetaskadapter(tasklistitem)

        recyclerviewitemlist.adapter = adapter

    }

}