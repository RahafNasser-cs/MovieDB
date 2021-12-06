package com.example.moviedb.network

import com.example.moviedb.utility.ui.capitalizeFormat

enum class MovieType(val id: Int) {
    ANIMATION(16), ACTION(28), ADVENTURE(12), COMEDY(35), CRIME(80),
    DOCUMENTARY(99), DRAMA(18), FAMILY(10751), FANTASY(14), HISTORY(36),
    HORROR(27), MUSIC(10402), MYSTERY(9648),
    ROMANCE(10749), SCIENCE_FICTION(878), TV_MOVIE(10770), THRILLER(53), WAR(10752), WESTERN(37), NULL(
        0
    )
}

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

    val vote_count: Int,
) {
    lateinit var movieType: MovieType
    var isFavMovie: Boolean = false

    init {
        setMovieType()
    }

    fun getVoteAverage(): String = vote_average.toString()

    // to set moive type
    fun setMovieType() {
        for (type in MovieType.values()) {
            if (genre_ids.contains(type.id)) {
                movieType = type
            }
        }
    }

    fun movieTypeAsString(): String {
        return movieType.toString().capitalizeFormat()
    }
}
