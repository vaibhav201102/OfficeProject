package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.CallHistoryitems
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.databinding.LayoutCallHistoryItemBinding
import com.tupleinfotech.officeproject.databinding.LayoutInterviewListBinding

class HRCallHistoryAdapter(var hostlist : List<CallHistoryitems>)  : RecyclerView.Adapter<HRCallHistoryAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: LayoutCallHistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HRCallHistoryAdapter.ViewHolder {
        val binding = LayoutCallHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: HRCallHistoryAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder) {
            with(hostlist[position]) {
                binding.departmentTv.text = curuntitem.Dept
                binding.nameTv.text = curuntitem.Name
                binding.prevExpTv.text = curuntitem.PrevExp
                binding.cityTv.text = curuntitem.City
                binding.dateTv.text = curuntitem.Date
            }
        }
    }

}