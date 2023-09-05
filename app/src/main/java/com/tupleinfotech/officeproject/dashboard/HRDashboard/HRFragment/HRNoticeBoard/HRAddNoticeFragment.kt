package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRNoticeBoard

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.databinding.FragmentAddNoticeBinding
import java.util.Calendar

class HRAddNoticeFragment : Fragment() {

    private var _binding : FragmentAddNoticeBinding?= null
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
        _binding = FragmentAddNoticeBinding.inflate(inflater,container,false)
        val view = binding.root

        init()

        return view
    }

    private fun init(){
        binding.addnoticeActionbar.titleText.text = "Add Notice"
        initback()
        onbackpressed()
        selectDate()
    }
    private fun initback(){
        binding.addnoticeActionbar.arrowBnt.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onbackpressed(){
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

        binding.selectDateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year

                    binding.selectDateEt.setText(
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