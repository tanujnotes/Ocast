package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getGenres(level: Int): Response<GenreResponse>
}