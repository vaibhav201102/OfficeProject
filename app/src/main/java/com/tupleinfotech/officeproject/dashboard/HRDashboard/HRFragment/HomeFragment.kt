package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.Employeetaskadapter
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRtaskAdapter
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

        init()
        return view
    }
    private fun init(){
        tasklist()
    }


    private fun tasklist(){
        tasklistitem= listOf(
            employeetasklistitems("My Tasks","99"),
            employeetasklistitems("Interview","99"),
            employeetasklistitems("Meeting","99"),
            employeetasklistitems("My team","99"),
            employeetasklistitems("Call Details","99"),
            employeetasklistitems("TimeSheet","99"),
        )

        val recyclerviewitemlist = binding.rv
        val layoutManager = GridLayoutManager(requireActivity(), 3)

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRtaskAdapter(tasklistitem)


        recyclerviewitemlist.adapter = adapter

    }

}