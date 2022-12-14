package com.ariefzuhri.makanbuah.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariefzuhri.makanbuah.databinding.ItemBenefitBinding

class BenefitAdapter : RecyclerView.Adapter<BenefitAdapter.BenefitViewHolder>() {

    private val benefitList = mutableListOf<String>()

    fun submitList(newBenefitList: List<String>) {
        benefitList.apply {
            notifyItemRangeRemoved(0, itemCount)
            clear()
            addAll(newBenefitList)
            notifyItemRangeInserted(0, itemCount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitViewHolder {
        val binding = ItemBenefitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BenefitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BenefitViewHolder, position: Int) {
        val benefit = benefitList[position]
        holder.bind(benefit)
    }

    override fun getItemCount(): Int {
        return benefitList.size
    }

    inner class BenefitViewHolder(private val binding: ItemBenefitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(benefit: String) {
            binding.initView(benefit)
        }

        private fun ItemBenefitBinding.initView(benefit: String) {
            tvBenefit.text = benefit
        }
    }
}