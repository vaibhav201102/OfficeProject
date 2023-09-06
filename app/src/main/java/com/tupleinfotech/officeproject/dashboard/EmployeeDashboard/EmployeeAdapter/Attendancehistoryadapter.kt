package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeAdapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.attendancehistorylistitems
import com.tupleinfotech.officeproject.databinding.LayoutAttendanceHistoryBinding

class Attendancehistoryadapter(var hostlist : List<attendancehistorylistitems>,var isfromdashboard : Boolean):
    RecyclerView.Adapter<Attendancehistoryadapter.ViewHolder>(){

    var onItemClick: ((attendancehistorylistitems) -> Unit)? = null

    inner class ViewHolder(val binding: LayoutAttendanceHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): Attendancehistoryadapter.ViewHolder {
        val binding = LayoutAttendanceHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: Attendancehistoryadapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder){
            with(hostlist[position]){

                if (isfromdashboard == true) {
                    binding.dateTv.text = curuntitem.date
                    binding.moduleNameTv.text = curuntitem.description
                    binding.workedHrsTv.text = curuntitem.attendancehrs
                    binding.startEndtimeTv.text = curuntitem.startendtime
                    binding.nameTv.visibility = VISIBLE

                    holder.itemView.setOnClickListener {
                        onItemClick?.invoke(hostlist[position])
                    }
                }else{
                    binding.dateTv.text = curuntitem.date
                    binding.moduleNameTv.text = curuntitem.description
                    binding.workedHrsTv.text = curuntitem.attendancehrs
                    binding.startEndtimeTv.text = curuntitem.startendtime
                    binding.nameTv.visibility = GONE

                    holder.itemView.setOnClickListener {
                        onItemClick?.invoke(hostlist[position])
                    }
                }
            }
        }
    }

}