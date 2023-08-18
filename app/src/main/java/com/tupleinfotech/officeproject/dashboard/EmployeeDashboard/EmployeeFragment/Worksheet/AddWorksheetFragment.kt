package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Worksheet

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentAddWorksheetBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class AddWorksheetFragment : Fragment(), TimePickerDialog.OnTimeSetListener  {

    private var _binding : FragmentAddWorksheetBinding?= null
    private val binding get() =  _binding!!
    private lateinit var selecteditem : Any
    private val formatter = SimpleDateFormat("hh:mm a", Locale.US)
    val selectedCalendar = Calendar.getInstance() // Calendar instance to store selected date and time

    private var selectedSignInCalendar = Calendar.getInstance() // Calendar instance to store selected sign-in date
    private var selectedSignOutCalendar = Calendar.getInstance() // Calendar instance to store selected sign-out date
    private var selectedDateCalendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddWorksheetBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        return view
    }

    private fun init(){
        binding.addsheetActionbar.titleText.text = "Add Sheet"
        initback()
        onbackpressed()
        setselectypeSpinner()
        selectDate()
        signindatepicker()
        signoutdatepicker()
        breaktimepicker()
    }

    private fun initback(){
        binding.addsheetActionbar.arrowBnt.setOnClickListener {
            val controller = Navigation.findNavController(requireView())
            controller.popBackStack(R.id.addWorksheetFragment, true)
        }
    }

    private fun onbackpressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val controller = Navigation.findNavController(requireView())
                controller.popBackStack(R.id.addWorksheetFragment, true)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

    private fun setselectypeSpinner() {

        val genderArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.workingdaytype, R.layout.layout_spinner_item)

        genderArrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item)

        binding.selectTypeEt.spinner.adapter = genderArrayAdapter

        binding.selectTypeEt.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            )  {
                selecteditem = binding.selectTypeEt.spinner.selectedItem.toString()


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Toast.makeText(requireContext(),"Please select SPgender" ,Toast.LENGTH_SHORT).show()
            }

        }


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

                    selectedDateCalendar.set(Calendar.YEAR, year)
                    selectedDateCalendar.set(Calendar.MONTH, month)
                    selectedDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    binding.selectDateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            dayOfMonth,month + 1,year
                        )
                    )

                }, cYear, cMonth, cDay)

            val minDate = Calendar.getInstance()
            minDate.add(Calendar.DAY_OF_MONTH, -2)
            calendarDialog.datePicker.minDate = minDate.timeInMillis

            val maxDate = Calendar.getInstance()
            maxDate.add(Calendar.DAY_OF_MONTH,0)
            calendarDialog.datePicker.maxDate = maxDate.timeInMillis

            calendarDialog.show()
        })
    }

    private fun signindatepicker() {

        fun showDatePicker() {
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    selectedSignInCalendar.set(Calendar.YEAR, year)
                    selectedSignInCalendar.set(Calendar.MONTH, month)
                    selectedSignInCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    // Show the time picker dialog after selecting the date
                    showsigninTimePicker(selectedSignInCalendar)
                },
                selectedDateCalendar.get(Calendar.YEAR),
                selectedDateCalendar.get(Calendar.MONTH),
                selectedDateCalendar.get(Calendar.DAY_OF_MONTH)
            )

            // Set maximum and minimum date to the selected date
            datePickerDialog.datePicker.minDate = selectedDateCalendar.timeInMillis
            datePickerDialog.datePicker.maxDate = selectedDateCalendar.timeInMillis

            datePickerDialog.show()
        }

        binding.signInTimeEt.setOnClickListener {
            showDatePicker()
        }
    }

    private fun signoutdatepicker() {

        fun showDatePicker() {
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    selectedSignOutCalendar.set(Calendar.YEAR, year)
                    selectedSignOutCalendar.set(Calendar.MONTH, month)
                    selectedSignOutCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    // Show the time picker dialog after selecting the date
                    showsignoutTimePicker(selectedSignOutCalendar)
                },
                selectedSignInCalendar.get(Calendar.YEAR),
                selectedSignInCalendar.get(Calendar.MONTH),
                selectedSignInCalendar.get(Calendar.DAY_OF_MONTH)
            )

            // Set maximum date to two days before the current date
            // Set minimum date to two days before the current date
            // Set minimum date to current date
            // Set minimum date to the selected sign-in date
            datePickerDialog.datePicker.minDate = selectedSignInCalendar.timeInMillis

            // Set maximum date to one day after the selected sign-in date
            val maxDate = Calendar.getInstance()
            maxDate.timeInMillis = selectedSignInCalendar.timeInMillis
            maxDate.add(Calendar.DAY_OF_MONTH, 0)
            datePickerDialog.datePicker.maxDate = maxDate.timeInMillis

            datePickerDialog.show()
        }

        binding.signOutTimeEt.setOnClickListener {
            showDatePicker()
        }
    }

    @SuppressLint("NewApi")
    fun showsigninTimePicker(selectedCalendar: Calendar) {

        TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->

                selectedCalendar.set(Calendar.HOUR_OF_DAY, selectedHour)
                selectedCalendar.set(Calendar.MINUTE, selectedMinute)

                val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())
                val formattedDateTime = sdf.format(selectedCalendar.time)
                binding.signInTimeEt.setText(formattedDateTime)
            },
            selectedCalendar.get(Calendar.HOUR_OF_DAY),
            selectedCalendar.get(Calendar.MINUTE),
            false
        ).show()

    }

    @SuppressLint("NewApi")
    fun showsignoutTimePicker(selectedCalendar: Calendar) {

        TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->

                // Parse the sign-in date and time from the EditText field
                val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())
                val signInDateTime = sdf.parse(binding.signInTimeEt.text.toString())
                val signInCalendar = Calendar.getInstance()
                signInCalendar.time = signInDateTime

                // Check if selected time is later than or equal to sign-in time
                val selectedDateTime = selectedCalendar.clone() as Calendar
                selectedDateTime.set(Calendar.HOUR_OF_DAY, selectedHour)
                selectedDateTime.set(Calendar.MINUTE, selectedMinute)

                if (!selectedDateTime.before(signInCalendar)) {

                    val formattedDateTime = sdf.format(selectedDateTime.time)
                    binding.signOutTimeEt.setText(formattedDateTime)

                } else {
                    // Display an error message or handle as desired
                    Toast.makeText(requireContext(), "Sign-out time cannot be earlier than sign-in time", Toast.LENGTH_SHORT).show()
                }

            },
            selectedCalendar.get(Calendar.HOUR_OF_DAY), // Initial hour
            selectedCalendar.get(Calendar.MINUTE),      // Initial minute
            false
        ).show()
    }


    @SuppressLint("NewApi")
    private fun breaktimepicker() {

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->

                val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                binding.breaktimeEt.setText(formattedTime)

            },
            0,
            0,
            true
        )

        binding.breaktimeEt.setOnClickListener {
            timePickerDialog.show()
        }
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

        val selectedTime = Calendar.getInstance()
        selectedTime.set(Calendar.HOUR_OF_DAY, p1)
        selectedTime.set(Calendar.MINUTE, p2)

        selectedCalendar.apply {
            set(Calendar.HOUR_OF_DAY, p1)
            set(Calendar.MINUTE, p2)
        }
        signintimedisplayformatter(selectedCalendar.timeInMillis)
        signouttimedisplayformatter(selectedCalendar.timeInMillis)

    }

    private fun signintimedisplayformatter(timestamp: Long) {
        binding.signInTimeEt.setText(formatter.format(timestamp))
        Log.i("Formatting", formatter.format(timestamp).toString())
    }

    private fun signouttimedisplayformatter(timestamp: Long) {
        binding.signOutTimeEt.setText(formatter.format(timestamp))
        Log.i("Formatting", formatter.format(timestamp).toString())
    }

}