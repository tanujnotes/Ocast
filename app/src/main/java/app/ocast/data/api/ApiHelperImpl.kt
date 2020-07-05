package app.ocast.data.api

import app.ocast.data.model.Genre
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getGenres(): Response<List<Genre>> = apiService.getGenres()

}