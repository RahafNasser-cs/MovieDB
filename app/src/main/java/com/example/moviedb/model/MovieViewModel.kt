package com.example.moviedb.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.network.ResultsItem
import kotlinx.coroutines.launch
import java.lang.Exception

enum class MovieApiStatus { LOADING, ERROR, DONE }

class MovieViewModel : ViewModel() {
    private var _movie = MutableLiveData<List<ResultsItem>>()
    val movie: MutableLiveData<List<ResultsItem>> get() = _movie
    private var _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> get() = _status
    var _favMovies = MutableLiveData<List<ResultsItem>>()
    val favMovies: MutableLiveData<List<ResultsItem>> get() = _favMovies

    private var _movieTitle = MutableLiveData<String>()
    val movieTitle: MutableLiveData<String> get() = _movieTitle
    private var _movieImageUrl = MutableLiveData<String>()
    val movieImageUrl: MutableLiveData<String> get() = _movieImageUrl
    private var _movieReleaseDate = MutableLiveData<String>()
    val movieReleaseDate: MutableLiveData<String> get() = _movieReleaseDate
    private var _movieDescription = MutableLiveData<String>()
    val movieDescription: MutableLiveData<String> get() = _movieDescription
    private var _movieVoteAverage = MutableLiveData<String>()
    val movieVoteAverage: MutableLiveData<String> get() = _movieVoteAverage

    init {
        getMovie()
        setFavMovieList()
    }

    private fun getMovie() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _movie.value = MovieApi.retrofitService.getInfo().results
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                Log.d("viewModelScope", "error --> $e")
                _status.value = MovieApiStatus.ERROR
                movie.value = listOf()
            }
        }
    }

    fun setFavMovieList() {
        _favMovies.value = favMovieList.loadFavMovie()
    }

    fun addFavMovie(movie: ResultsItem) {
        favMovieList.addMovie(movie)
    }

    companion object {
        val favMovieList = FavouriteMovies()
    }
}
