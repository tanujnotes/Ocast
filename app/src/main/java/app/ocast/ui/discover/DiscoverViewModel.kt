package app.ocast.ui.discover

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ocast.data.model.GenreResponse
import app.ocast.data.repository.GenreRepository
import app.ocast.utils.NetworkHelper
import app.ocast.utils.Resource
import kotlinx.coroutines.launch

class DiscoverViewModel @ViewModelInject constructor(
    private val genreRepository: GenreRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _genres = MutableLiveData<Resource<GenreResponse>>()
    val genres: LiveData<Resource<GenreResponse>>
        get() = _genres

    init {
        fetchGenres()
    }

    private fun fetchGenres() {
        viewModelScope.launch {
            _genres.postValue(Resource.loading(null))
            if (!networkHelper.isNetworkConnected()) {
                _genres.postValue(Resource.error("No Internet!", null))
                return@launch
            }
            genreRepository.getGenres().let {
                if (it.isSuccessful)
                    _genres.postValue(Resource.success(it.body()))
                else
                    _genres.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}