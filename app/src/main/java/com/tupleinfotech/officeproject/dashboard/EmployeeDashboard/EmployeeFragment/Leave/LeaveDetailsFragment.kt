package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Leave

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentLeaveBinding
import com.tupleinfotech.officeproject.databinding.FragmentLeaveDetailsBinding

class LeaveDetailsFragment : Fragment() {

    private var _binding : FragmentLeaveDetailsBinding?= null
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
        _binding = FragmentLeaveDetailsBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        // Inflate the layout for this fragment
        return view
    }

    private fun init(){

        binding.leaveDetailsActionbar.titleText.text = "Leave Details"
        initback()
        onbackpressed()
    }

    private fun initback(){
        binding.leaveDetailsActionbar.arrowBnt.setOnClickListener {
            val controller = Navigation.findNavController(requireView())
            controller.popBackStack(R.id.leaveDetailsFragment, true)
        }
    }

    private fun onbackpressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val controller = Navigation.findNavController(requireView())
                controller.popBackStack(R.id.leaveDetailsFragment, true)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

}