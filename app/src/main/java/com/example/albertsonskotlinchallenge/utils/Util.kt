package com.example.albertsonskotlinchallenge.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*

object Util {
    fun capitalizeByWords(input: String): String {
        val words = input.lowercase(Locale.getDefault()).split(" ").toTypedArray()
        val builder = StringBuilder()
        for (i in words.indices) {
            val word = words[i]
            if (i > 0 && word.length > 0) {
                builder.append(" ")
            }
            val cap = word.substring(0, 1).uppercase(Locale.getDefault()) + word.substring(1)
            builder.append(cap)
        }
        return builder.toString()
    }

    fun hideKeyboard(activity: Activity?) {
        if (activity == null) return
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}