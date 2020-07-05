package app.ocast.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import app.ocast.R
import app.ocast.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : Fragment() {

    private val discoverViewModel: DiscoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initObservers()
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    private fun initObservers() {
        discoverViewModel.genres.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
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
}