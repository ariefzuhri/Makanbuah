package com.ariefzuhri.makanbuah.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariefzuhri.makanbuah.common.util.getDrawable
import com.ariefzuhri.makanbuah.data.model.Fruit
import com.ariefzuhri.makanbuah.databinding.ItemFruitBinding

class FruitAdapter : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    private val fruitList = mutableListOf<Fruit>()
    private var listener: EventListener? = null

    fun submitList(newFruitList: List<Fruit>) {
        fruitList.apply {
            notifyItemRangeRemoved(0, itemCount)
            clear()
            addAll(newFruitList)
            notifyItemRangeInserted(0, itemCount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.bind(fruit)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    inner class FruitViewHolder(private val binding: ItemFruitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(fruit: Fruit) {
            binding.initView(fruit)
            binding.initClickListeners(fruit)
        }

        private fun ItemFruitBinding.initView(fruit: Fruit) {
            tvName.text = fruit.name
            imgPhoto.setImageDrawable(context.getDrawable(fruit.photoId))
        }

        private fun ItemFruitBinding.initClickListeners(fruit: Fruit) {
            root.setOnClickListener {
                listener?.onItemClick(fruit)
            }
        }
    }

    fun setEventListener(listener: EventListener?) {
        this.listener = listener
    }

    interface EventListener {

        fun onItemClick(fruit: Fruit)
    }
}