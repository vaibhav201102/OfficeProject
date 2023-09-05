package com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminAdapter.AdmintaskAdapter
import com.tupleinfotech.officeproject.databinding.FragmentAdminHomeBinding

class AdminHomeFragment : Fragment() {

    private var _binding : FragmentAdminHomeBinding?= null
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
        _binding = FragmentAdminHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        init()
        // Inflate the layout for this fragment
        return view
    }
    private fun init(){
        tasklist()
    }


    private fun tasklist(){
        tasklistitem= listOf(
            employeetasklistitems("Interview","99"),
            employeetasklistitems("Leave","99"),
            employeetasklistitems("Meeting","99"),
            employeetasklistitems("Login","99"),
            employeetasklistitems("Employee Details","99"),
            employeetasklistitems("TimeSheet","99"),
        )

        val recyclerviewitemlist = binding.rv
        val layoutManager = GridLayoutManager(requireActivity(), 3)

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = AdmintaskAdapter(tasklistitem)


        recyclerviewitemlist.adapter = adapter

    }

}