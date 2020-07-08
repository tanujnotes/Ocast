package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import app.ocast.data.model.PodcastResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getGenres(level: Int): Response<GenreResponse>
    suspend fun getBestPodcasts(genreId: String, page: Int): Response<PodcastResponse>
}