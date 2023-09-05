package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRInterviews

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentAddInterviewBinding
import com.tupleinfotech.officeproject.databinding.FragmentInterviewListBinding
import java.util.Calendar

class HRAddInterviewFragment : Fragment() {

    private var _binding : FragmentAddInterviewBinding?= null
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
        _binding = FragmentAddInterviewBinding.inflate(inflater,container,false)
        val view = binding.root
        init()
        // Inflate the layout for this fragment
        return view
    }
    private fun init(){
        binding.AddinterviewActionbar.titleText.text = "Add Interview"
        selectDate()
        initback()
        onBackPressed()
    }
    private fun initback(){
        binding.AddinterviewActionbar.arrowBnt.setOnClickListener {
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

    private fun selectDate() {
        val c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        binding.scheduleDateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year

                    binding.scheduleDateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            month + 1, dayOfMonth,year
                        )
                    )
                }, cYear, cMonth, cDay)

            val c1 = Calendar.getInstance()
            calendarDialog.datePicker.minDate = c1.timeInMillis
            calendarDialog.show()
        })
    }

}