package com.realestate.app.utils

import java.text.NumberFormat
import java.util.Locale

fun Long.toPriceValue(): String = try {
    NumberFormat.getCurrencyInstance(
        Locale.Builder().setLanguage("de").setRegion("CH").build()
    ).format(this)
} catch (e: Exception) {
    e.printStackTrace()
    Defaults.DEFAULT_STRING
}