package com.example.moviedb.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.network.MovieType
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
    var tempMovieList = mutableListOf<ResultsItem>()

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
    private var _isFavMovie = MutableLiveData<Boolean>()
    val isFavMovie: MutableLiveData<Boolean> get() = _isFavMovie
    private var _backdropPath = MutableLiveData<String>()
    val backdropPath: MutableLiveData<String> get() = _backdropPath
    private var _movieType = MutableLiveData<String>()
    val movieType: MutableLiveData<String> get() = _movieType

    init {
        getMovie()
        setFavMovieList()
    }

    private fun getMovie() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _movie.value = MovieApi.retrofitService.getInfo().results
                tempMovieList = _movie.value!!.toMutableList()
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                Log.d("viewModelScope", "error --> $e")
                _status.value = MovieApiStatus.ERROR
                movie.value = listOf()
            }
        }
    }

    fun getMoviesById(id: Int?) {
        if (id == null) {
            _movie.value = tempMovieList
        }
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _movie.value = MovieApi.retrofitService.getMoviesByType(id).results
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

    fun setMovieType() {
        _movie.value!!.forEach {
            if (it.title == _movieTitle.value!!) {
                _movieType.value = it.movieType.toString()
            }
        }
    }

    fun loadMovieList(filterTag: MovieType) {
        if (filterTag == MovieType.NULL) {
            _movie.value = tempMovieList.toList()
        } else {
            var filteredlist = tempMovieList
            var types = mutableListOf<MovieType>()
            filteredlist.forEach { types.add(it.movieType) }
            Log.d("ViewModel --> loadMovieList() before filter", "list of movie type$types")
            _movie.value = filteredlist.filter { it.movieType == filterTag }.toList()
            _movie.value!!.forEach { types.add(it.movieType) }
            Log.d("ViewModel --> loadMovieList() after", "list of movie type$types")
        }
    }

    companion object {
        val favMovieList = FavouriteMovies()
    }
}
