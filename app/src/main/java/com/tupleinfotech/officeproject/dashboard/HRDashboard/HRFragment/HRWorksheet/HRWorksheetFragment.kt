package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRFragment.HRWorksheet

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tupleinfotech.officeproject.Models.attendancehistorylistitems
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.Attendancehistoryadapter
import com.tupleinfotech.officeproject.databinding.FragmentWorksheetBinding
import java.util.Calendar

class HRWorksheetFragment : Fragment() {

    private var _binding : FragmentWorksheetBinding?= null
    private val binding get() =  _binding!!

    private lateinit var attendancehistorylistitems: List<attendancehistorylistitems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorksheetBinding.inflate(inflater,container,false)
        val view = binding.root


        init()

        return view
    }

    private fun init(){
        selectDate()
        attendancehistory()

        binding.empSheetActionbar.titleText.text = "Employee Sheet"
        binding.empSheetActionbar.arrowBnt.visibility = View.GONE

        binding.btnAddEntry.setOnClickListener {
            findNavController().navigate(R.id.HRAddWorksheetFragment)
        }
    }
    private fun selectDate() {
        val c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)


        binding.startdateEt.setText(
            String.format("%02d/%02d/%04d", cDay, cMonth + 1, cYear)
        )
        binding.enddateEt.setText(
            String.format("%02d/%02d/%04d", cDay, cMonth + 1, cYear)
        )

        binding.startdateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year

                    binding.startdateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            dayOfMonth,month + 1,year
                        )
                    )

                }, cYear, cMonth, cDay)
            calendarDialog.show()
        })

        binding.enddateEt.setOnClickListener(View.OnClickListener {
            /**set CalendarDialog*/
            val calendarDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener {
                        view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year

                    binding.enddateEt.setText(
                        String.format(
                            "%02d/%02d/%02d",
                            dayOfMonth,month + 1,year
                        )
                    )

                }, cYear, cMonth, cDay)
            calendarDialog.show()
        })
    }

    private fun attendancehistory(){

        attendancehistorylistitems = listOf(
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
            attendancehistorylistitems("24 hrs","12:12 AM - 11:59 PM","Office Project","12/08/2023"),
        )


        val recyclerviewitemlist = binding.attendanceRv
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = Attendancehistoryadapter(attendancehistorylistitems,false)

        adapter.onItemClick = {
            findNavController().navigate(R.id.HRSheetDetailsFragment)
        }

        recyclerviewitemlist.adapter = adapter
    }

}