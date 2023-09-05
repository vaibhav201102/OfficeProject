package com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter.Employeetaskadapter
import com.tupleinfotech.officeproject.databinding.LayoutEmployeeTasksBinding
import com.tupleinfotech.officeproject.databinding.LayoutHrTasksBinding

class AdmintaskAdapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<AdmintaskAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutHrTasksBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdmintaskAdapter.ViewHolder {
        val binding = LayoutHrTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: AdmintaskAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {
                binding.appCompatTextView.text = curuntitem.taskname
            }
        }
    }

}