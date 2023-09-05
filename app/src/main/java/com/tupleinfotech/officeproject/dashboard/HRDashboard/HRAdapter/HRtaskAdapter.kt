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
    var onItemClick: ((employeetasklistitems) -> Unit)? = null
    var onItemClick1: ((employeetasklistitems) -> Unit)? = null
    var onItemClick2: ((employeetasklistitems) -> Unit)? = null
    var onItemClick3: ((employeetasklistitems) -> Unit)? = null
    var onItemClick4: ((employeetasklistitems) -> Unit)? = null
    var onItemClick5: ((employeetasklistitems) -> Unit)? = null

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

                if (position == 0) {
                    holder.itemView.setOnClickListener {
                        onItemClick?.invoke(hostlist[position])
                    }
                } else if (position == 1) {
                    holder.itemView.setOnClickListener {
                        onItemClick1?.invoke(hostlist[position])
                    }
                }else if (position == 2) {
                    holder.itemView.setOnClickListener {
                        onItemClick2?.invoke(hostlist[position])
                    }
                }else if (position == 3) {
                    holder.itemView.setOnClickListener {
                        onItemClick3?.invoke(hostlist[position])
                    }
                }else if (position == 4) {
                    holder.itemView.setOnClickListener {
                        onItemClick4?.invoke(hostlist[position])
                    }
                }else if (position == 5) {
                    holder.itemView.setOnClickListener {
                        onItemClick5?.invoke(hostlist[position])
                    }
                }
            }
        }
    }

}