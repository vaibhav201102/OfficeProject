package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.attendancehistorylistitems
import com.tupleinfotech.officeproject.databinding.LayoutAttendanceHistoryBinding

class Leavehistoryadapter(var hostlist : List<attendancehistorylistitems>):
    RecyclerView.Adapter<Leavehistoryadapter.ViewHolder>(){

    var onItemClick: ((attendancehistorylistitems) -> Unit)? = null

    inner class ViewHolder(val binding: LayoutAttendanceHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Leavehistoryadapter.ViewHolder {
        val binding = LayoutAttendanceHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: Leavehistoryadapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder){
            with(hostlist[position]){

                binding.workedHrsTv.visibility = View.GONE

                binding.dateTv.text = curuntitem.date
                binding.moduleNameTv.text = curuntitem.description
                binding.startEndtimeTv.text = curuntitem.startendtime

                holder.itemView.setOnClickListener {
                    onItemClick?.invoke(hostlist[position])
                }
            }
        }
    }

}