package app.ocast.data.repository

import app.ocast.data.api.ApiHelper
import javax.inject.Inject

class PodcastRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getBestPodcasts(genreId: String, page: Int) = apiHelper.getBestPodcasts(genreId, page)

}