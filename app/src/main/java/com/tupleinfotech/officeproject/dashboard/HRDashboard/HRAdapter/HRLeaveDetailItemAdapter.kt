package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.databinding.LayoutInterviewListBinding
import com.tupleinfotech.officeproject.databinding.LayoutLeaveDetailsItemBinding

class HRLeaveDetailItemAdapter(var hostlist : List<InterviewListItem>)  :RecyclerView.Adapter<HRLeaveDetailItemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: LayoutLeaveDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HRLeaveDetailItemAdapter.ViewHolder {
        val binding = LayoutLeaveDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HRLeaveDetailItemAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {
                binding.typeTv.text = curuntitem.Type
                binding.statusTxtTv.text = curuntitem.Status
                binding.durationTv.text = curuntitem.Dept
                binding.durationDateTv.text = curuntitem.Date
                binding.descTv.text = curuntitem.Name

            }
        }

    }

    override fun getItemCount(): Int {
        return hostlist.size
    }
}