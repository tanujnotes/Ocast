package app.ocast.ui.podcasts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import app.ocast.data.model.PodcastResponse
import app.ocast.databinding.FragmentPodcastsBinding
import app.ocast.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PodcastsFragment : Fragment() {
    private val podcastsViewModel: PodcastsViewModel by viewModels()
    private lateinit var adapter: PodcastAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPodcastsBinding.inflate(inflater, container, false)
        binding.genreName = arguments?.getString("genreName")
        podcastsViewModel.fetchBestPodcasts(arguments?.getInt("genreId").toString(), 1)

        adapter = PodcastAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter

        initObservers()
        return binding.root
    }

    private fun initObservers() {
        podcastsViewModel.podcasts.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                    it.data?.let { podcasts -> renderList(podcasts) }
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

    private fun renderList(podcasts: PodcastResponse) {
        adapter.submitList(podcasts.podcasts)
        adapter.notifyDataSetChanged()
    }
}