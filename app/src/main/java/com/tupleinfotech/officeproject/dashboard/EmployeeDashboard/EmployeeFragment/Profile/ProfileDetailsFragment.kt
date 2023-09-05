package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import com.tupleinfotech.officeproject.databinding.FragmentProfileDetailsBinding

class ProfileDetailsFragment : Fragment() {

    private var _binding : FragmentProfileDetailsBinding?= null
    private val binding get() =  _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileDetailsBinding.inflate(inflater,container,false)
        val view = binding.root

        // Inflate the layout for this fragment
        init()
        return view
    }

    private fun init(){
        binding.profiledetailsActionbar.titleText.text = "Profile"
        binding.profiledetailsActionbar.arrowBnt.visibility = GONE

    }


}