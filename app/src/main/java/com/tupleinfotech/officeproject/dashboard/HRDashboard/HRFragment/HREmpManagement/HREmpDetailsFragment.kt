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
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HREmpDetailsAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HREmpManagementAdapter
import com.tupleinfotech.officeproject.databinding.FragmentEmpDetailsBinding
import com.tupleinfotech.officeproject.databinding.FragmentEmpManagementBinding

class HREmpDetailsFragment : Fragment() {

    private var _binding : FragmentEmpDetailsBinding?= null
    private val binding get() =  _binding!!
    private lateinit var empManagementItem: List<EmpManagementItem>

    private var FromEmpDetails : Boolean = false
    private var FromEmpTimeAttendance : Boolean = false
    private var FromEmpleaveManagement : Boolean = false
    private var FromEmpOvertime : Boolean = false
    private var FromEmpSalaryStatement : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            FromEmpDetails = it.getBoolean("Employee details", FromEmpDetails)
            FromEmpTimeAttendance = it.getBoolean("Employee time attendance", FromEmpTimeAttendance)
            FromEmpleaveManagement =it.getBoolean("Employee leave management", FromEmpleaveManagement)
            FromEmpOvertime = it.getBoolean("Employees overtime", FromEmpOvertime)
            FromEmpSalaryStatement =it.getBoolean("Employee salary statement", FromEmpSalaryStatement)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmpDetailsBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        return view
    }

    private fun init(){
        binding.empDetailsActionbar.titleText.text = "Employee Details"
        initback()
        onBackPressed()
        initempmanagementitem()
        println(FromEmpDetails)
        println(FromEmpTimeAttendance)
        println(FromEmpleaveManagement)
        println(FromEmpOvertime)
        println(FromEmpSalaryStatement)
    }

    private fun initback(){
        binding.empDetailsActionbar.arrowBnt.setOnClickListener {
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
            EmpManagementItem("Name","Designation"),
            EmpManagementItem("Name","Designation"),
            EmpManagementItem("Name","Designation"),
            EmpManagementItem("Name","Designation"),
            EmpManagementItem("Name","Designation"),
            EmpManagementItem("Name","Designation"),
        )

        val recyclerviewitemlist = binding.empDetailsRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HREmpDetailsAdapter(empManagementItem)

        adapter.onItemClick = {
                if (FromEmpDetails == true){
                    findNavController().navigate(R.id.employeeDetailsFragment)
                }
                else if (FromEmpTimeAttendance == true){
                    findNavController().navigate(R.id.employeeWorksheetFragment)
                }
                else if (FromEmpleaveManagement == true){
                    findNavController().navigate(R.id.HRLeaveManagementFragment)
                }
                else if (FromEmpOvertime == true){
//            findNavController().navigate(R.id.employeeDetailsFragment)
                }
                else if (FromEmpSalaryStatement == true){
                    findNavController().navigate(R.id.HRSalarySlipFragment)
                }
        }

        //Item Clicks

        recyclerviewitemlist.adapter = adapter

    }

}