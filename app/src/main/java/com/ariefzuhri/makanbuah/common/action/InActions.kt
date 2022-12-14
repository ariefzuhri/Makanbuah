package com.ariefzuhri.makanbuah.common.action

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.fragment.findNavController
import com.ariefzuhri.makanbuah.R
import com.ariefzuhri.makanbuah.common.util.getBitmapFromDrawable
import com.ariefzuhri.makanbuah.data.model.Fruit
import com.ariefzuhri.makanbuah.ui.fragment.ListFragment
import com.ariefzuhri.makanbuah.ui.fragment.ListFragmentDirections

fun Context?.openCustomTabs(url: String?) {
    this?.let { context ->
        CustomTabsIntent.Builder().apply {
            setShowTitle(true)
            getBitmapFromDrawable(R.drawable.ic_back_24)?.let { icon -> setCloseButtonIcon(icon) }
            build().launchUrl(context, Uri.parse(url))
        }
    }
}

fun ListFragment?.goToAbout() {
    this?.findNavController()?.navigate(
        ListFragmentDirections.actionListToAbout()
    )
}

fun ListFragment?.goToDetails(fruit: Fruit) {
    this?.findNavController()?.navigate(
        ListFragmentDirections.actionListToDetails(fruit)
    )
}