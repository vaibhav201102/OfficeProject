package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRCallDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentAddCallBinding
import com.tupleinfotech.officeproject.databinding.FragmentCallDetailsBinding

class HRAddCallFragment : Fragment() {

    private var _binding : FragmentAddCallBinding?= null
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
        _binding = FragmentAddCallBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        init()
        return view
    }

    private fun init(){
        binding.addCallActionbar.titleText.text = "Add Details"
        initback()
        onBackPressed()
    }
    private fun initback(){
        binding.addCallActionbar.arrowBnt.setOnClickListener {
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