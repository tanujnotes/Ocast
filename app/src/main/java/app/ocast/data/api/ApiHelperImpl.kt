package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getGenres(level: Int): Response<GenreResponse> = apiService.getGenres(level)

}