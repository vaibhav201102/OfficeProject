package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.databinding.LayoutMonthlyreportDataBinding

class EmployeeMonthlyReportDataAdapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<EmployeeMonthlyReportDataAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutMonthlyreportDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutMonthlyreportDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder) {
            with(hostlist[position]) {
                binding.appCompatTextView.text = curuntitem.taskname
                binding.numberofdaysTv.text = curuntitem.taskiconcount
            }
        }
    }

}