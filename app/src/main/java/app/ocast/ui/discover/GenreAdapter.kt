package app.ocast.ui.discover

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ocast.R
import app.ocast.data.model.Genre
import app.ocast.databinding.AdapterGenreBinding

class GenreAdapter : ListAdapter<Genre, GenreAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterGenreBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genre = getItem(position)
        holder.apply {
            bind(createOnClickListener(genre.id, genre.name), genre)
            itemView.tag = genre
        }
    }

    private fun createOnClickListener(id: Int, name: String): View.OnClickListener {
        return View.OnClickListener {
            it.findNavController().navigate(R.id.action_navigation_discover_to_podcastsFragment)
        }
    }

    class ViewHolder(
        private val binding: AdapterGenreBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Genre) {
            binding.apply {
                clickListener = listener
                genre = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Genre>() {

    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem == newItem
    }
}