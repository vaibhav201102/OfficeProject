package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.CallHistoryitems
import com.tupleinfotech.officeproject.Models.EmpManagementItem
import com.tupleinfotech.officeproject.databinding.LayoutCallHistoryItemBinding
import com.tupleinfotech.officeproject.databinding.LayoutEmpManagementItemBinding
import com.tupleinfotech.officeproject.databinding.LayoutSalarySlipItemBinding

class HREmpSalarySlipAdapter(var hostlist : List<EmpManagementItem>)  : RecyclerView.Adapter<HREmpSalarySlipAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutSalarySlipItemBinding) : RecyclerView.ViewHolder(binding.root)

    var onItemClick: ((EmpManagementItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HREmpSalarySlipAdapter.ViewHolder {
        val binding = LayoutSalarySlipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HREmpSalarySlipAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder) {
            with(hostlist[position]) {

                binding.nameTv.text = curuntitem.Itemname

                holder.binding.imgItem.setOnClickListener {
                    onItemClick?.invoke(hostlist[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }

}