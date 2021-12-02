import com.example.moviedb.network.MovieInfoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.themoviedb.org"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("/3/movie/popular?api_key=aecfaa3cec82d0f9182bbf8e19b77f75")
    suspend fun getInfo(): MovieInfoResponse

    @GET("https://api.themoviedb.org/3/discover/movie?api_key=aecfaa3cec82d0f9182bbf8e19b77f75")
    suspend fun getMoviesByType(@Query("with_genres") id: Int?): MovieInfoResponse
}

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}
