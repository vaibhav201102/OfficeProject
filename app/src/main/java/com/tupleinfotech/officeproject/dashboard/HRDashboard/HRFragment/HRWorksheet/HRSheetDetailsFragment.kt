package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRWorksheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.databinding.FragmentSheetDetailsBinding

class HRSheetDetailsFragment : Fragment() {
    private var _binding : FragmentSheetDetailsBinding?= null
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
        _binding = FragmentSheetDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment

        binding.sheetDetailsActionbar.titleText.text = "Sheet Details"

        init()

        return view
    }

    private fun init(){
        initback()
        onBackPressed()
    }
    private fun initback(){
        binding.sheetDetailsActionbar.arrowBnt.setOnClickListener {
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