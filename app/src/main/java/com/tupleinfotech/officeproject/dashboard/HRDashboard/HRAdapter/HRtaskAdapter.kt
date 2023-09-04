package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.Employeetaskadapter
import com.tupleinfotech.officeproject.databinding.LayoutEmployeeTasksBinding
import com.tupleinfotech.officeproject.databinding.LayoutHrTasksBinding

class HRtaskAdapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<HRtaskAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutHrTasksBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HRtaskAdapter.ViewHolder {
        val binding = LayoutHrTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: HRtaskAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {
                binding.appCompatTextView.text = curuntitem.taskname
            }
        }
    }

}