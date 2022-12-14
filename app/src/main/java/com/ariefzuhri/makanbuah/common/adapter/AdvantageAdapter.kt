package com.ariefzuhri.makanbuah.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariefzuhri.makanbuah.databinding.ItemAdvantageBinding

class AdvantageAdapter : RecyclerView.Adapter<AdvantageAdapter.AdvantageViewHolder>() {

    private val advantageList = mutableListOf<String>()

    fun submitList(newAdvantageList: List<String>) {
        advantageList.apply {
            notifyItemRangeRemoved(0, itemCount)
            clear()
            addAll(newAdvantageList)
            notifyItemRangeInserted(0, itemCount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvantageViewHolder {
        val binding = ItemAdvantageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AdvantageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdvantageViewHolder, position: Int) {
        val advantage = advantageList[position]
        holder.bind(advantage)
    }

    override fun getItemCount(): Int {
        return advantageList.size
    }

    inner class AdvantageViewHolder(private val binding: ItemAdvantageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(advantage: String) {
            binding.initView(advantage)
        }

        private fun ItemAdvantageBinding.initView(advantage: String) {
            tvAdvantage.text = advantage
        }
    }
}