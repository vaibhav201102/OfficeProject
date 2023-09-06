package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.officeproject.Models.EmpManagementItem
import com.tupleinfotech.officeproject.databinding.LayoutEmpDetailsItemBinding

class HREmpDetailsAdapter(var hostlist : List<EmpManagementItem>)  : RecyclerView.Adapter<HREmpDetailsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutEmpDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    var onItemClick : ((EmpManagementItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HREmpDetailsAdapter.ViewHolder {
        val binding = LayoutEmpDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HREmpDetailsAdapter.ViewHolder, position: Int) {
        val curuntitem = hostlist[position]

        with(holder) {
            with(hostlist[position]) {
                binding.empdetailsItem.profileNameTv.text = curuntitem.Itemname.toString()
                binding.empdetailsItem.profileDesgTv.text = curuntitem.ItemDesgination.toString()

                holder.itemView.setOnClickListener {
                    onItemClick?.invoke(hostlist[position])
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return hostlist.size
    }
}