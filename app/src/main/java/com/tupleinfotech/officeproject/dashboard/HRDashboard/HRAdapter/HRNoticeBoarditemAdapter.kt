package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.Noticeboarditem
import com.tupleinfotech.officeproject.Models.employeetasklistitems
import com.tupleinfotech.officeproject.databinding.LayoutHrTasksBinding
import com.tupleinfotech.officeproject.databinding.LayoutNoticeboardItemBinding

class HRNoticeBoarditemAdapter(var hostlist : List<Noticeboarditem>)  :
    RecyclerView.Adapter<HRNoticeBoarditemAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: LayoutNoticeboardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HRNoticeBoarditemAdapter.ViewHolder {
        val binding = LayoutNoticeboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

    override fun onBindViewHolder(holder: HRNoticeBoarditemAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]
        with(holder) {
            with(hostlist[position]) {
                binding.noticeDateTv.text = curuntitem.Date
                binding.noticeTitleTv.text= curuntitem.title
                binding.noticeDescTv.text= curuntitem.Description
            }
        }
    }

}
