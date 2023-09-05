package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRMeetings

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentAddMeetingBinding
import com.tupleinfotech.officeproject.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HRAddMeetingFragment : Fragment(), TimePickerDialog.OnTimeSetListener {

    private var _binding : FragmentAddMeetingBinding?= null
    private val binding get() =  _binding!!
    private val calendar = Calendar.getInstance()
    private var time : String ?= null

    private val formatterforservice = SimpleDateFormat("hh:mm a", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMeetingBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        init()
        return view
    }

    private fun init(){
        binding.addMeetingActionbar.titleText.text = "Add Meeting"

        initback()
        onBackPressed()
        selectDate()
        selecttime()
    }
    private fun initback(){
        binding.addMeetingActionbar.arrowBnt.setOnClickListener{
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

    private fun selecttime(){
        binding.selectTimeEt.setOnClickListener {
            val currentTime = Calendar.getInstance()
            currentTime.add(Calendar.HOUR_OF_DAY, 0)

            val timePickerDialog = TimePickerDialog(
                requireActivity(),
                this,
                currentTime.get(Calendar.HOUR_OF_DAY),
                currentTime.get(Calendar.MINUTE),
                false
            )
            timePickerDialog.updateTime(
                currentTime.get(Calendar.HOUR_OF_DAY),
                currentTime.get(Calendar.MINUTE)
            )
            timePickerDialog.show()
        }
    }
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = Calendar.getInstance()
        selectedTime.add(Calendar.HOUR_OF_DAY, 1)
        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
        selectedTime.set(Calendar.MINUTE, minute)

        calendar.apply {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
        }
        displayFormattedtime(calendar.timeInMillis)
    }
    private fun displayFormattedtime(timestamp: Long) {
        time = formatterforservice.format(timestamp)
        Log.i("Formatting", formatterforservice.format(timestamp))
        binding.selectTimeEt.setText(time.toString())
    }

}