package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.InterviewListItem
import com.tupleinfotech.officeproject.databinding.LayoutInterviewListBinding
import com.tupleinfotech.officeproject.databinding.LayoutNoticeboardItemBinding

class HRInterviewListitemAdapter(var hostlist : List<InterviewListItem>)  :
    RecyclerView.Adapter<HRInterviewListitemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: LayoutInterviewListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HRInterviewListitemAdapter.ViewHolder {
        val binding = LayoutInterviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HRInterviewListitemAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {

                binding.nameTv.text = curuntitem.Name
                binding.dateTxtTv.text= curuntitem.Date
                binding.deptTv.text= curuntitem.Dept
                binding.expTv.text= curuntitem.Exp
                binding.typeTxtTv.text= curuntitem.Type
                binding.statusTv.text= curuntitem.Status

            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }


}