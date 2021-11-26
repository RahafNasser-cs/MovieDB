package com.example.moviedb.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.network.ResultsItem
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel : ViewModel() {
    private var _movie = MutableLiveData<List<ResultsItem>>()
    val movie: MutableLiveData<List<ResultsItem>> get() = _movie

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            try {
                _movie.value = MovieApi.retrofitService.getInfo().results as List<ResultsItem>?
            } catch (e: Exception) {
                Log.d("viewModelScope", "error --> $e")
            }
        }
    }
}
