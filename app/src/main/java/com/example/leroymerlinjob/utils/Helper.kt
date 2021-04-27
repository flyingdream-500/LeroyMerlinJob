package com.example.leroymerlinjob.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.RelativeSizeSpan
import android.widget.EditText
import androidx.core.text.HtmlCompat


fun getRubleSymbol(): String {
    return HtmlCompat.fromHtml("&#x20bd;", HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
}

fun getEditedPrice(source: String): Spannable{
    val spannedProductPrice = SpannableString(source)
    spannedProductPrice.setSpan(
        RelativeSizeSpan(1.5f),
        0, source.indexOf(getRubleSymbol()), 0)
    return spannedProductPrice
}
