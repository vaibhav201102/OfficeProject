package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Leave

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.FragmentAddLeaveBinding
import java.util.Calendar

class AddLeaveFragment : Fragment() {

    private var _binding : FragmentAddLeaveBinding?= null
    private val binding get() =  _binding!!
    private lateinit var selectleavetype : Any
    private lateinit var selectstartdatetype : Any
    private lateinit var selectenddatetype : Any

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddLeaveBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        // Inflate the layout for this fragment
        return view
    }
    private fun init(){
        binding.addLeaveActionbar.titleText.text = "Add Leave"
        initback()
        onbackpressed()
        setselecleavetypeSpinner()
        setselecstartdatetypeSpinner()
        setselecenddatetypeSpinner()
        selectstartdate()
    }

    private fun initback(){
        binding.addLeaveActionbar.arrowBnt.setOnClickListener {
            val controller = Navigation.findNavController(requireView())
            controller.popBackStack(R.id.addLeaveFragment, true)
        }
    }

    private fun onbackpressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val controller = Navigation.findNavController(requireView())
                controller.popBackStack(R.id.addLeaveFragment, true)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

    private fun setselecleavetypeSpinner() {

        val genderArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.leavedaytype, R.layout.layout_spinner_item)

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
                selectleavetype = binding.selectTypeEt.spinner.selectedItem.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Toast.makeText(requireContext(),"Please select SPgender" ,Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun setselecstartdatetypeSpinner() {

        val genderArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.startenddatetype, R.layout.layout_spinner_item)

        genderArrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item)

        binding.selectStartDateTypeEt.spinner.adapter = genderArrayAdapter

        binding.selectStartDateTypeEt.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            )  {
                selectstartdatetype = binding.selectTypeEt.spinner.selectedItem.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Toast.makeText(requireContext(),"Please select SPgender" ,Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun setselecenddatetypeSpinner() {

        val genderArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.startenddatetype, R.layout.layout_spinner_item)

        genderArrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item)

        binding.selectEndDateTypeEt.spinner.adapter = genderArrayAdapter

        binding.selectEndDateTypeEt.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            )  {
                selectenddatetype = binding.selectTypeEt.spinner.selectedItem.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Toast.makeText(requireContext(),"Please select SPgender" ,Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun selectstartdate(){
        val c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        binding.startDateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year


                    binding.startDateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            dayOfMonth,month + 1,year
                        )
                    )

                }, cYear, cMonth, cDay)

            val minDate = Calendar.getInstance()
            minDate.timeInMillis = System.currentTimeMillis() // Set the minimum date to the current date
            calendarDialog.datePicker.minDate = minDate.timeInMillis

            calendarDialog.show()
        })

        binding.endDateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year


                    binding.endDateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            dayOfMonth,month + 1,year
                        )
                    )

                }, cYear, cMonth, cDay)

            val minDate = Calendar.getInstance()
            minDate.timeInMillis = System.currentTimeMillis() // Set the minimum date to the current date
            calendarDialog.datePicker.minDate = minDate.timeInMillis

            calendarDialog.show()
        })

    }

}