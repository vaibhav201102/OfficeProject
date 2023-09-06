package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.CallHistoryitems
import com.tupleinfotech.officeproject.Models.EmpManagementItem
import com.tupleinfotech.officeproject.databinding.LayoutCallHistoryItemBinding
import com.tupleinfotech.officeproject.databinding.LayoutEmpManagementItemBinding

class HREmpManagementAdapter(var hostlist : List<EmpManagementItem>)  : RecyclerView.Adapter<HREmpManagementAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutEmpManagementItemBinding) : RecyclerView.ViewHolder(binding.root)

    var onItemClick: ((EmpManagementItem) -> Unit)? = null
    var onItemClick1: ((EmpManagementItem) -> Unit)? = null
    var onItemClick2: ((EmpManagementItem) -> Unit)? = null
    var onItemClick3: ((EmpManagementItem) -> Unit)? = null
    var onItemClick4: ((EmpManagementItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HREmpManagementAdapter.ViewHolder {
        val binding = LayoutEmpManagementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HREmpManagementAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder) {
            with(hostlist[position]) {
                binding.nameTv.text = curuntitem.Itemname.toString()

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
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

}