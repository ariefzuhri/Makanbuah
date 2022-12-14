package com.ariefzuhri.makanbuah.common.action

import android.content.Context
import android.content.Intent
import com.ariefzuhri.makanbuah.R

fun Context?.share(text: String) {
    this?.let { context ->
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        context.startActivity(Intent.createChooser(intent, getString(R.string.share)))
    }
}