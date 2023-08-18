package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.databinding.LayoutEmployeeTasksBinding

class employeetaskadapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<employeetaskadapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutEmployeeTasksBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): employeetaskadapter.ViewHolder {
        val binding = LayoutEmployeeTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: employeetaskadapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder){
            with(hostlist[position]){

                binding.appCompatTextView.text = curuntitem.taskname
            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }
}