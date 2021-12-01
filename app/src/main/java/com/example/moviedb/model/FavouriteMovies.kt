package com.example.moviedb.model

import android.view.View
import android.widget.Toast
import com.example.moviedb.network.ResultsItem

class FavouriteMovies {
    val favMoviesList = mutableListOf<ResultsItem>()
    fun loadFavMovie(): List<ResultsItem> {
        return favMoviesList
    }

    fun addMovie(item: ResultsItem, view: View?) {
        if (favMoviesList.contains(item)) {
            favMoviesList.remove(item)
            Toast.makeText(view?.context, "${item.title} remove from favourite", Toast.LENGTH_SHORT)
                .show()
        } else {
            favMoviesList.add(item)
            Toast.makeText(view?.context, "${item.title} add to favourite", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
