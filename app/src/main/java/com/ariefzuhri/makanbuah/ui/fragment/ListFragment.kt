package com.ariefzuhri.makanbuah.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ariefzuhri.makanbuah.R
import com.ariefzuhri.makanbuah.common.action.goToAbout
import com.ariefzuhri.makanbuah.common.action.goToDetails
import com.ariefzuhri.makanbuah.common.adapter.FruitAdapter
import com.ariefzuhri.makanbuah.common.base.BaseFragment
import com.ariefzuhri.makanbuah.data.dummy.FruitDummyData
import com.ariefzuhri.makanbuah.data.model.Fruit
import com.ariefzuhri.makanbuah.databinding.FragmentListBinding

class ListFragment : BaseFragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val fruitAdapter = FruitAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFruitRecyclerView()
        populateFruitAdapter()

        initClickListeners()
    }

    private fun initFruitRecyclerView() {
        binding.rvFruit.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = fruitAdapter
            setHasFixedSize(true)

            fruitAdapter.setEventListener(object : FruitAdapter.EventListener {
                override fun onItemClick(fruit: Fruit) {
                    goToDetails(fruit)
                }
            })
        }
    }

    private fun populateFruitAdapter() {
        val fruits = FruitDummyData.get()
        fruitAdapter.submitList(fruits)
    }

    private fun initClickListeners() {
        binding.apply {
            tbList.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_about -> goToAbout()
                }
                true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}