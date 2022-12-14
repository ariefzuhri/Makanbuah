package com.ariefzuhri.makanbuah.common.base

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun Toolbar?.init() {
        this?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}