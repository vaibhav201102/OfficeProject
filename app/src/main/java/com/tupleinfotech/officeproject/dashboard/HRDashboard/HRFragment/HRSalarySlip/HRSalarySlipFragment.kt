package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRSalarySlip

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
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HREmpSalarySlipAdapter
import com.tupleinfotech.officeproject.databinding.FragmentHomeBinding
import com.tupleinfotech.officeproject.databinding.FragmentSalarySlipBinding

class HRSalarySlipFragment : Fragment() {

    private var _binding : FragmentSalarySlipBinding?= null
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
        _binding = FragmentSalarySlipBinding.inflate(inflater,container,false)
        val view = binding.root

        init()

        return view
    }
    private fun init(){
        binding.salarySlipActionbar.titleText.text = "Salary Slip"
        initback()
        onBackPressed()
        initsalaryslipitem()
    }

    private fun initback(){
        binding.salarySlipActionbar.arrowBnt.setOnClickListener {
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

    private fun initsalaryslipitem(){
        empManagementItem = listOf(
            EmpManagementItem("Month/Year",""),
            EmpManagementItem("Month/Year",""),
            EmpManagementItem("Month/Year",""),
            EmpManagementItem("Month/Year",""),
            EmpManagementItem("Month/Year",""),
            EmpManagementItem("Month/Year",""),
        )

        val recyclerviewitemlist = binding.salarySlipMonthwiseRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HREmpSalarySlipAdapter(empManagementItem)

        adapter.onItemClick = {
        }

        recyclerviewitemlist.adapter = adapter

    }


}