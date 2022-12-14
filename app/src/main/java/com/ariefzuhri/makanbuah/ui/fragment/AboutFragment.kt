package com.ariefzuhri.makanbuah.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ariefzuhri.makanbuah.common.base.BaseFragment
import com.ariefzuhri.makanbuah.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.apply {
            tbAbout.init()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}