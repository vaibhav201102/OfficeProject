package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRInterviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRInterviewListitemAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRtaskAdapter
import com.tupleinfotech.officeproject.databinding.FragmentHomeBinding
import com.tupleinfotech.officeproject.databinding.FragmentInterviewListBinding

class HRInterviewListFragment : Fragment() {

    private var _binding : FragmentInterviewListBinding?= null
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
        _binding = FragmentInterviewListBinding.inflate(inflater,container,false)
        val view = binding.root

        init()

        return view
    }

    private fun init(){
        binding.interiewListingActionbar.titleText.text = "Interviews"
        initinterviewListItem()
        initback()
        onBackPressed()
        Addinterview()
    }

    private fun initinterviewListItem(){
        interviewListItem = listOf(
            InterviewListItem("NAME","DATE","DEPT","EXP","TYPE","STATUS"),
            InterviewListItem("NAME","DATE","DEPT","EXP","TYPE","STATUS"),
            InterviewListItem("NAME","DATE","DEPT","EXP","TYPE","STATUS"),
            InterviewListItem("NAME","DATE","DEPT","EXP","TYPE","STATUS"),
        )

        val recyclerviewitemlist = binding.interviewListItemRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRInterviewListitemAdapter(interviewListItem)

        //click events

        recyclerviewitemlist.adapter = adapter

    }

    private fun initback(){
        binding.interiewListingActionbar.arrowBnt.setOnClickListener {
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

    private fun Addinterview(){
        binding.btnAddInterview.setOnClickListener {
            findNavController().navigate(R.id.HRAddInterviewFragment)
        }
    }

}