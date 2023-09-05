package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRMeetings

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
import com.tupleinfotech.officeproject.Models.Noticeboarditem
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRInterviewListitemAdapter
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRMeetinglistitemAdapter
import com.tupleinfotech.officeproject.databinding.FragmentInterviewListBinding
import com.tupleinfotech.officeproject.databinding.FragmentMeetingListBinding

class HRMeetingListFragment : Fragment() {

    private var _binding : FragmentMeetingListBinding?= null
    private val binding get() =  _binding!!
    private lateinit var meetingListitem: List<Noticeboarditem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingListBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        // Inflate the layout for this fragment
        return view
    }

    private fun init(){
        binding.meetingListingActionbar.titleText.text = "Meetings"
        initback()
        onBackPressed()
        initmeetingitemlist()
        Addmeeting()
    }
    private fun initback(){
        binding.meetingListingActionbar.arrowBnt.setOnClickListener {
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

    private fun initmeetingitemlist(){
        meetingListitem = listOf(
            Noticeboarditem("NAME","DATE","DEPT"),
            Noticeboarditem("NAME","DATE","DEPT"),
            Noticeboarditem("NAME","DATE","DEPT"),
            Noticeboarditem("NAME","DATE","DEPT"),
        )

        val recyclerviewitemlist = binding.meetingListItemRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRMeetinglistitemAdapter(meetingListitem)

        //click events

        recyclerviewitemlist.adapter = adapter
    }
    private fun Addmeeting(){
        binding.btnAddMeeting.setOnClickListener {
            findNavController().navigate(R.id.HRAddMeetingFragment)
        }
    }

}