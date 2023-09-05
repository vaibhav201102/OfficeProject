package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRNoticeBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.Noticeboarditem
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter.HRNoticeBoarditemAdapter
import com.tupleinfotech.officeproject.databinding.FragmentNoticeBoardBinding

class HRNoticeBoardFragment : Fragment() {

    private var _binding : FragmentNoticeBoardBinding?= null
    private val binding get() =  _binding!!

    private lateinit var noticeboarditem: List<Noticeboarditem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoticeBoardBinding.inflate(inflater,container,false)
        val view = binding.root

        // Inflate the layout for this fragment
        init()
        return view
    }

    private fun init(){
        binding.noticebarActionbar.titleText.text = "Notice Board"
        binding.noticebarActionbar.arrowBnt.visibility = View.GONE
        noticeDetails()
        Addnotice()
    }

    private fun noticeDetails(){

        noticeboarditem = listOf(
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
            Noticeboarditem("Title","Date","Description"),
        )


        val recyclerviewitemlist = binding.noticeRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = HRNoticeBoarditemAdapter(noticeboarditem)

        recyclerviewitemlist.adapter = adapter
    }

    private fun Addnotice(){
        binding.addNoticeBtn.setOnClickListener {
            findNavController().navigate(R.id.HRAddNoticeFragment)
        }
    }

}