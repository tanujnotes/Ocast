package app.ocast.data.api

import app.ocast.data.model.GenreResponse
import app.ocast.data.model.PodcastResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getGenres(level: Int): Response<GenreResponse> =
        apiService.getGenres(level)

    override suspend fun getBestPodcasts(genreId: String, page: Int): Response<PodcastResponse> =
        apiService.getBestPodcasts(genreId, page)

}