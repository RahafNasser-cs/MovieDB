package com.example.moviedb.utility.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.upToTop() {

    findNavController().popBackStack()
}

fun String.capitalizeFormat(): String {
    var temp = this[0]
    return this.lowercase().replace('_', ' ').replace(temp.lowercaseChar(), temp)
}
