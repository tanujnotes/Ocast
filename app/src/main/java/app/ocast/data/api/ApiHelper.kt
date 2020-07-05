package app.ocast.data.api

import app.ocast.data.model.Genre
import retrofit2.Response

interface ApiHelper {

    suspend fun getGenres(): Response<List<Genre>>
}