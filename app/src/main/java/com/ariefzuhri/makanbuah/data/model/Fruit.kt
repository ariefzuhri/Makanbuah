package com.ariefzuhri.makanbuah.data.model

import android.content.Context
import android.os.Parcelable
import com.ariefzuhri.makanbuah.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruit(
    val id: Int,
    val name: String,
    val photoId: String,
    val advantages: List<String>,
    val nutrition: String,
    val benefits: List<String>,
    val contentSource: String,
    val photoCredit: String,
    val readMoreUrl: String,
) : Parcelable {

    fun getAttributions(context: Context?): String {
        return context?.getString(R.string.attributions, contentSource, photoCredit).orEmpty()
    }

    fun getBuyUrl(): String {
        return "https://www.google.com/search?tbm=shop&q=$name+fruit"
    }

    fun getShareText(context: Context?): String {
        return context?.getString(R.string.share_text, name.lowercase(), readMoreUrl).orEmpty()
    }
}