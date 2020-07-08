package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import app.ocast.data.model.PodcastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("genres") // level - 0 for all genres, 1 for top genres, default 1
    suspend fun getGenres(@Query("top_level_only") level: Int = 1): Response<GenreResponse>

    @GET("best_podcasts") // TODO: add region query parameter
    suspend fun getBestPodcasts(
        @Query("genre_id") genreId: String,
        @Query("page") page: Int = 1,
        @Query("safe_mode") safe_mode: Int = 1 // add explicit language, 1 = yes, 0 = no
    ): Response<PodcastResponse>

}