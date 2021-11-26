package com.example.moviedb.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.network.MovieInfoResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel : ViewModel() {
    private var _movie = MutableLiveData<MovieInfoResponse>()
    val movie: MutableLiveData<MovieInfoResponse> get() = _movie

    init {
    }

    private fun getMovie() {
        viewModelScope.launch {
            try {
                _movie.value = MovieApi.retrofitService.getInfo()
            } catch (e: Exception) {
                Log.d("viewModelScope", "error --> $e")
            }
        }
    }
}
