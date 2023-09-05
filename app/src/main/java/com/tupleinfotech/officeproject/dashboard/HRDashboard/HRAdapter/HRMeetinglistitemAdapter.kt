package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.Noticeboarditem
import com.tupleinfotech.officeproject.databinding.LayoutMeetingItemBinding

class HRMeetinglistitemAdapter(var hostlist : List<Noticeboarditem>) :    RecyclerView.Adapter<HRMeetinglistitemAdapter.ViewHolder>()  {

    inner class ViewHolder(val binding: LayoutMeetingItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HRMeetinglistitemAdapter.ViewHolder {
        val binding = LayoutMeetingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: HRMeetinglistitemAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {
                binding.nameTv.text = curuntitem.title
                binding.typeTxtTv.text = curuntitem.Description
                binding.datetimeTv.text = curuntitem.Date

            }
        }
    }

}