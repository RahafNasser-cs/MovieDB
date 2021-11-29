package com.example.moviedb.utility.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.upToTop() {

    findNavController().popBackStack()
}
