package com.example.moviedb.network

data class MovieInfoResponse(

    val page: Int? = null,

    val total_pages: Int? = null,

    val results: List<ResultsItem?>? = null,

    val total_results: Int? = null
)

data class ResultsItem(

    val overview: String? = null,

    val original_language: String? = null,

    val original_title: String? = null,

    val video: Boolean? = null,

    val title: String? = null,

    val genre_ids: List<Int?>? = null,

    val poster_path: String? = null,

    val backdrop_path: String? = null,

    val release_date: String? = null,

    val popularity: Double? = null,

    val vote_average: Double? = null,

    val id: Int? = null,

    val adult: Boolean? = null,

    val vote_count: Int? = null
)
// @field:SerializedName("vote_count")
