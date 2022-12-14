package com.ariefzuhri.makanbuah.common.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap

fun Context?.getBitmapFromDrawable(drawableId: Int): Bitmap? {
    return this?.let { context ->
        ContextCompat.getDrawable(context, drawableId)
    }?.toBitmap()
}

fun Context?.getDrawable(filename: String): Drawable? {
    return this?.let { context ->
        val drawableId = context.resources.getIdentifier(filename, "drawable", packageName)
        return ContextCompat.getDrawable(context, drawableId)
    }
}