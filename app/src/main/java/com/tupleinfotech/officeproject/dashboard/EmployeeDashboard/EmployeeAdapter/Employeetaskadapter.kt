package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.databinding.LayoutEmployeeTasksBinding

class Employeetaskadapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<Employeetaskadapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutEmployeeTasksBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): Employeetaskadapter.ViewHolder {
        val binding = LayoutEmployeeTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Employeetaskadapter.ViewHolder, position: Int) {
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