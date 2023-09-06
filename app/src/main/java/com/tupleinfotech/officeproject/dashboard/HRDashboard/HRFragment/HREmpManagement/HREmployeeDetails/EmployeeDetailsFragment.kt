package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HREmpManagement.HREmployeeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentEmpDetailsBinding
import com.tupleinfotech.officeproject.databinding.FragmentEmployeeDetailsBinding

class EmployeeDetailsFragment : Fragment() {

    private var _binding : FragmentEmployeeDetailsBinding?= null
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
        _binding = FragmentEmployeeDetailsBinding.inflate(inflater,container,false)
        val view = binding.root

        init()

        return view
    }
    private fun init(){
        binding.employeeDetailsActionbar.titleText.text = "Employee Details"
        initback()
        onBackPressed()
    }
    private fun initback(){
        binding.employeeDetailsActionbar.arrowBnt.setOnClickListener {
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