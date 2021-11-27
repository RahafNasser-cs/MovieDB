package com.example.moviedb.model

import com.example.moviedb.network.ResultsItem

class FavouriteMovies {
    val favMoviesList = mutableListOf<ResultsItem>()
    fun loadFavMovie(): List<ResultsItem> {
        return favMoviesList
    }

    fun addMovie(item: ResultsItem) {
        if (favMoviesList.contains(item)) {
            favMoviesList.remove(item)
        } else {
            favMoviesList.add(item)
        }
    }
}
