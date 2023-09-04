package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.databinding.LayoutEmployeeTasksBinding

class Employeetaskadapter(var hostlist : List<employeetasklistitems>) :
    RecyclerView.Adapter<Employeetaskadapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutEmployeeTasksBinding) : RecyclerView.ViewHolder(binding.root)
    var onItemClick: ((employeetasklistitems) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): Employeetaskadapter.ViewHolder {
        val binding = LayoutEmployeeTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Employeetaskadapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder){
            with(hostlist[position]){
                binding.appCompatTextView.text = curuntitem.taskname

                if (position == 2) {
                    holder.itemView.setOnClickListener {
                        // Handle click on the 3rd item here
                        onItemClick?.invoke(hostlist[position])
                    }
                } else {
                    // For other items, you can set a different click behavior or no click behavior
                    holder.itemView.setOnClickListener(null) // Disable click
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }
}