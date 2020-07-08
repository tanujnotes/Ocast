package app.ocast.ui.podcasts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ocast.data.model.Podcast
import app.ocast.databinding.AdapterPodcastBinding

class PodcastAdapter : ListAdapter<Podcast, PodcastAdapter.ViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterPodcastBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val podcast = getItem(position)
        holder.apply {
            bind(createOnClickListener(podcast.id, podcast.title), podcast)
            itemView.tag = podcast
        }
    }

    private fun createOnClickListener(id: String, name: String): View.OnClickListener {
        return View.OnClickListener {
//            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: AdapterPodcastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Podcast) {
            binding.apply {
                clickListener = listener
                podcast = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Podcast>() {

    override fun areItemsTheSame(oldItem: Podcast, newItem: Podcast): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Podcast, newItem: Podcast): Boolean {
        return oldItem == newItem
    }
}