package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("genres")
    suspend fun getGenres(@Query("top_level_only") level: Int = 1): Response<GenreResponse>

}