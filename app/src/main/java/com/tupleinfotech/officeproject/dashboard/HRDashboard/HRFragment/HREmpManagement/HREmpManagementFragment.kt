package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HREmpManagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.EmpManagementItem
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HREmpManagementAdapter
import com.tupleinfotech.officeproject.databinding.FragmentEmpManagementBinding

class HREmpManagementFragment : Fragment() {

    private var _binding : FragmentEmpManagementBinding?= null
    private val binding get() =  _binding!!
    private lateinit var empManagementItem: List<EmpManagementItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmpManagementBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        // Inflate the layout for this fragment
        return view
    }
    private fun init(){
        binding.empManagementActionbar.titleText.text = "Employee management"
        initempmanagementitem()
        initback()
        onBackPressed()
    }
    private fun initback(){
        binding.empManagementActionbar.arrowBnt.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun onBackPressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }
    private fun initempmanagementitem(){
        empManagementItem = listOf(
            EmpManagementItem("Employee details",""),
            EmpManagementItem("Employee time attendance",""),
            EmpManagementItem("Employee leave management",""),
            EmpManagementItem("Employees overtime",""),
            EmpManagementItem("Employee salary statement",""),
        )

        val recyclerviewitemlist = binding.empManagementRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HREmpManagementAdapter(empManagementItem)

        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putBoolean("Employee details",true)
            findNavController().navigate(R.id.HREmpDetailsFragment,bundle)
            //Employee details
        }
        adapter.onItemClick1 = {
            val bundle = Bundle()
            bundle.putBoolean("Employee time attendance",true)
            findNavController().navigate(R.id.HREmpDetailsFragment,bundle)
            //Employee time attendance
        }
        adapter.onItemClick2 = {
            val bundle = Bundle()
            bundle.putBoolean("Employee leave management",true)
            findNavController().navigate(R.id.HREmpDetailsFragment,bundle)
            //Employee leave management
        }
        adapter.onItemClick3 = {
            val bundle = Bundle()
            bundle.putBoolean("Employees overtime",true)
            findNavController().navigate(R.id.HREmpDetailsFragment,bundle)
            //Employees overtime
        }
        adapter.onItemClick4 = {
            val bundle = Bundle()
            bundle.putBoolean("Employee salary statement",true)
            findNavController().navigate(R.id.HREmpDetailsFragment,bundle)
            //Employee salary statement
        }

        recyclerviewitemlist.adapter = adapter

    }

}