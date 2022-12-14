package com.ariefzuhri.makanbuah.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariefzuhri.makanbuah.R
import com.ariefzuhri.makanbuah.common.action.openCustomTabs
import com.ariefzuhri.makanbuah.common.action.share
import com.ariefzuhri.makanbuah.common.adapter.AdvantageAdapter
import com.ariefzuhri.makanbuah.common.adapter.BenefitAdapter
import com.ariefzuhri.makanbuah.common.base.BaseFragment
import com.ariefzuhri.makanbuah.common.util.getDrawable
import com.ariefzuhri.makanbuah.data.model.Fruit
import com.ariefzuhri.makanbuah.databinding.FragmentDetailsBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class DetailsFragment : BaseFragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var fruit: Fruit

    private val advantageAdapter = AdvantageAdapter()
    private val benefitAdapter = BenefitAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: DetailsFragmentArgs by navArgs()
        fruit = args.fruit
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdvantageRecyclerView()
        populateAdvantageAdapter()

        initBenefitRecyclerView()
        populateBenefitAdvantage()

        initView()
        initClickListeners()
    }

    private fun initAdvantageRecyclerView() {
        binding.apply {
            rvAdvantage.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = advantageAdapter
            }
        }
    }

    private fun populateAdvantageAdapter() {
        advantageAdapter.submitList(fruit.advantages)
    }

    private fun initBenefitRecyclerView() {
        binding.apply {
            rvBenefit.apply {
                layoutManager = FlexboxLayoutManager(context).apply {
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                adapter = benefitAdapter
            }
        }
    }

    private fun populateBenefitAdvantage() {
        benefitAdapter.submitList(fruit.benefits)
    }

    private fun initView() {
        binding.apply {
            tbDetails.init()

            tvName.text = fruit.name
            imgPhoto.setImageDrawable(context.getDrawable(fruit.photoId))
            tvNutrition.text = fruit.nutrition
            tvSource.text = fruit.getAttributions(context)
        }
    }

    private fun initClickListeners() {
        binding.apply {
            tbDetails.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_share -> {
                        context.share(fruit.getShareText(context))
                    }
                }
                true
            }
            tvReadMore.setOnClickListener {
                context.openCustomTabs(fruit.readMoreUrl)
            }
            fabBuy.setOnClickListener {
                context.openCustomTabs(fruit.getBuyUrl())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}