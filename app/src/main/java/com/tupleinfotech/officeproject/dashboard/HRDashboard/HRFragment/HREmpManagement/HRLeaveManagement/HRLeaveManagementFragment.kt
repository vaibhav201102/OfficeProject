package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HREmpManagement.HRLeaveManagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRInterviewListitemAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRLeaveDetailItemAdapter
import com.tupleinfotech.officeproject.databinding.FragmentEmpDetailsBinding
import com.tupleinfotech.officeproject.databinding.FragmentLeaveBinding
import com.tupleinfotech.officeproject.databinding.FragmentLeaveManagementBinding

class HRLeaveManagementFragment : Fragment() {

    private var _binding : FragmentLeaveManagementBinding?= null
    private val binding get() =  _binding!!
    private lateinit var interviewListItem: List<InterviewListItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveManagementBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        return view
    }
    private fun init(){

        binding.LeaveManagementActionbar.titleText.text = "Leave Management"
        binding.leaveBaalnceCircle.setProgress(75)
        binding.casualLeaveCircle.setProgress(75)
        binding.medicalLeaveCircle.setProgress(75)
        binding.annualLeaveCircle.setProgress(75)
        binding.leaveBalance.text = "5\nLeave Balance"

        initLeaveDetails()
        initback()
        onBackPressed()
    }

    private fun initLeaveDetails(){

        interviewListItem = listOf(
            InterviewListItem("Description","99/99/9999","From Date - To Date(99 Days)","EXP","TYPE","Rejected"),
            InterviewListItem("Description","99/99/9999","From Date - To Date(99 Days)","EXP","TYPE","Rejected"),
            InterviewListItem("Description","99/99/9999","From Date - To Date(99 Days)","EXP","TYPE","Rejected"),
            InterviewListItem("Description","99/99/9999","From Date - To Date(99 Days)","EXP","TYPE","Rejected"),
        )

        val recyclerviewitemlist = binding.leaveDetailsItemRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRLeaveDetailItemAdapter(interviewListItem)

        //click events

        recyclerviewitemlist.adapter = adapter
    }
    private fun initback(){
        binding.LeaveManagementActionbar.arrowBnt.setOnClickListener {
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

}