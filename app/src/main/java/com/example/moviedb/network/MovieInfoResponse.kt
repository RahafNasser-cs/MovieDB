package com.example.moviedb.network

data class MovieInfoResponse(

    val page: Int,

    val total_pages: Int,

    val results: List<ResultsItem>,

    val total_results: Int
)

data class ResultsItem(

    val overview: String,

    val original_language: String,

    val original_title: String,

    val video: Boolean,

    val title: String,

    val genre_ids: List<Int>,

    val poster_path: String,

    val backdrop_path: String,

    val release_date: String,

    val popularity: Double,

    val vote_average: Double,

    val id: Int,

    val adult: Boolean,

    val vote_count: Int
) {
    fun getVoteAverage(): String = vote_average.toString()
}
