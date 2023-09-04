package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeFragment.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.EmployeeMonthlyReportDataAdapter
import com.tupleinfotech.officeproject.databinding.FragmentMonthlyReportBinding
import java.util.Calendar

class MonthlyReportFragment : Fragment() {

    private var _binding : FragmentMonthlyReportBinding?= null
    private val binding get() =  _binding!!
    private lateinit var tasklistitem: List<employeetasklistitems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthlyReportBinding.inflate(inflater,container,false)
        val view = binding.root

        init()
        return view
    }

    private fun init(){
        binding.MonthlyReportActionbar.arrowBnt.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.MonthlyReportActionbar.titleText.text = "Monthly Report"
        barChartData()
        onbackpressed()
        initmothlyreportdays()
    }

    private fun barChartData() {
        val chartEntries: ArrayList<BarEntry> = ArrayList()

        val calendar = Calendar.getInstance()
        val maxValue = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        // Generate data for all days of the month
        for (day in 1..maxValue) {
            val yValue = (1..10).random().toFloat() // Adjust the range as needed
            chartEntries.add(BarEntry(day.toFloat(), yValue))
        }

        val barDataSet = BarDataSet(chartEntries, "Hours")
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.office_main)
        barDataSet.isHighlightEnabled = false

        val barData = BarData(barDataSet)
        barData.barWidth = 0.5f

        binding.reviewGraph.barChart.data = barData

        val xAxis = binding.reviewGraph.barChart.xAxis
        xAxis.isEnabled = true
        xAxis.granularity = 1f // Set X-axis interval to 1f
        xAxis.labelRotationAngle = 0f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)

        binding.reviewGraph.barChart.axisLeft.isEnabled = true
        binding.reviewGraph.barChart.axisRight.isEnabled = false
        binding.reviewGraph.barChart.legend.isEnabled = true
        binding.reviewGraph.barChart.description.isEnabled = false

        // Disable pinch-to-zoom
        binding.reviewGraph.barChart.setPinchZoom(false)
        binding.reviewGraph.barChart.setScaleEnabled(false)

        binding.reviewGraph.barChart.isDoubleTapToZoomEnabled = false
        binding.reviewGraph.barChart.setVisibleXRangeMaximum(8f)
    }

    private fun onbackpressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

    private fun initmothlyreportdays(){
        tasklistitem= listOf(
            employeetasklistitems("Present","99"),
            employeetasklistitems("Absent","99"),
            employeetasklistitems("Holiday","99"),
            employeetasklistitems("Half Day","99"),
            employeetasklistitems("Week off","99"),
            employeetasklistitems("leave","99"),
        )

        val recyclerviewitemlist = binding.rv
        val layoutManager = GridLayoutManager(requireActivity(), 3)

        recyclerviewitemlist.layoutManager = layoutManager
        recyclerviewitemlist.itemAnimator = DefaultItemAnimator()

        val adapter = EmployeeMonthlyReportDataAdapter(tasklistitem)

        recyclerviewitemlist.adapter = adapter
    }

}