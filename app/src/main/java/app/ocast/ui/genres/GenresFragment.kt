package app.ocast.ui.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import app.ocast.data.model.GenreResponse
import app.ocast.databinding.FragmentGenresBinding
import app.ocast.ui.discover.DiscoverViewModel
import app.ocast.ui.discover.GenreAdapter
import app.ocast.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GenresFragment : Fragment() {
    private val discoverViewModel: DiscoverViewModel by viewModels()
    private lateinit var adapter: GenreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGenresBinding.inflate(inflater, container, false)
        discoverViewModel.fetchGenres(0) // 0 for all genres, 1 for top genres

        adapter = GenreAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter

        initObservers()
        return binding.root
    }

    private fun initObservers() {
        discoverViewModel.genres.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { genres -> renderList(genres) }
                }
                Resource.Status.LOADING -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun renderList(genres: GenreResponse) {
        adapter.submitList(genres.results)
        adapter.notifyDataSetChanged()
    }
}