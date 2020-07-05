package app.ocast.data.repository

import app.ocast.data.api.ApiHelper
import javax.inject.Inject

class GenreRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getGenres() = apiHelper.getGenres()

}