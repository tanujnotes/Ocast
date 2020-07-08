package app.ocast.ui.podcasts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ocast.data.model.PodcastResponse
import app.ocast.data.repository.PodcastRepository
import app.ocast.utils.NetworkHelper
import app.ocast.utils.Resource
import kotlinx.coroutines.launch

class PodcastsViewModel @ViewModelInject constructor(
    private val podcastRepository: PodcastRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _podcasts = MutableLiveData<Resource<PodcastResponse>>()
    val podcasts: LiveData<Resource<PodcastResponse>>
        get() = _podcasts

//    init {
//        fetchBestPodcasts()
//    }

    fun fetchBestPodcasts(genreId: String, page: Int) {
        viewModelScope.launch {
            _podcasts.postValue(Resource.loading(null))
            if (!networkHelper.isNetworkConnected()) {
                _podcasts.postValue(Resource.error("No Internet!", null))
                return@launch
            }
            podcastRepository.getBestPodcasts(genreId, page).let {
                if (it.isSuccessful)
                    _podcasts.postValue(Resource.success(it.body()))
                else
                    _podcasts.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}