package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Leave

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.attendancehistorylistitems
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.Leavehistoryadapter
import com.tupleinfotech.officeproject.databinding.FragmentLeaveBinding


class LeaveFragment : Fragment() {

    private var _binding : FragmentLeaveBinding?= null
    private val binding get() =  _binding!!
    private lateinit var attendancehistorylistitems: List<attendancehistorylistitems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.empSheetActionbar.titleText.text = "Leave History"
        binding.empSheetActionbar.arrowBnt.visibility = View.GONE

        // Inflate the layout for this fragment
        init()
        return view
    }
    private fun init(){
        attendancehistory()
        addleavebtn()
    }

    private fun addleavebtn(){
        binding.btnAddEntry.setOnClickListener {
            findNavController().navigate(R.id.addLeaveFragment)
        }
    }
    private fun attendancehistory(){

        attendancehistorylistitems = listOf(
            attendancehistorylistitems("24 hrs","12/12/2021 - 12/12/2022","Annual","Approved"),
            attendancehistorylistitems("24 hrs","12/12/2021 - 12/12/2022","Annual","Approved"),
            attendancehistorylistitems("24 hrs","12/12/2021 - 12/12/2022","Annual","Approved"),

        )


        val recyclerviewitemlist = binding.leavehistoryRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = Leavehistoryadapter(attendancehistorylistitems)

        adapter.onItemClick = {
            findNavController().navigate(R.id.leaveDetailsFragment)
        }

        recyclerviewitemlist.adapter = adapter
    }
}