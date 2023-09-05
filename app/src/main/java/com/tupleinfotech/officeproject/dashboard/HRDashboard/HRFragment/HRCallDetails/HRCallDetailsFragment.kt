package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRCallDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.CallHistoryitems
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRCallHistoryAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRInterviewListitemAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRMeetinglistitemAdapter
import com.tupleinfotech.officeproject.databinding.FragmentCallDetailsBinding
import com.tupleinfotech.officeproject.databinding.FragmentInterviewListBinding

class HRCallDetailsFragment : Fragment() {

    private var _binding : FragmentCallDetailsBinding?= null
    private val binding get() =  _binding!!
    private lateinit var callHistoryitems: List<CallHistoryitems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCallDetailsBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        return view
    }
    private fun init(){
        binding.callDetailsActionbar.titleText.text = "Calls"
        Datewisesearchbar()
        initinterviewListItem()
        AddCall()
        initback()
        onBackPressed()
    }

    private fun Datewisesearchbar(){
        binding.callDetailsSegment.segmentBtnDatewise.setOnClickListener {
            binding.searchCl.visibility = VISIBLE
        }
        binding.callDetailsSegment.segmentBtnToday.setOnClickListener {
            binding.searchCl.visibility = GONE
        }
    }
    private fun initback(){
        binding.callDetailsActionbar.arrowBnt.setOnClickListener {
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

    private fun initinterviewListItem(){
        callHistoryitems = listOf(
            CallHistoryitems("Date","DEPT","Name","PrevEXP","City"),
            CallHistoryitems("Date","DEPT","Name","PrevEXP","City"),
            CallHistoryitems("Date","DEPT","Name","PrevEXP","City"),
            CallHistoryitems("Date","DEPT","Name","PrevEXP","City"),
        )

        val recyclerviewitemlist = binding.callListRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRCallHistoryAdapter(callHistoryitems)

        //click events

        recyclerviewitemlist.adapter = adapter

    }

    private fun AddCall(){
        binding.btnAddCalls.setOnClickListener {
            findNavController().navigate(R.id.HRAddCallFragment)
        }
    }

}