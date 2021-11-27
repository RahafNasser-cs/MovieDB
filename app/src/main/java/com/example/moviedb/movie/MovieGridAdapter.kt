package com.example.moviedb.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.databinding.GridViewItemBinding
import com.example.moviedb.network.ResultsItem

class MovieGridAdapter :
    ListAdapter<ResultsItem, MovieGridAdapter.MovieViewHolder>(DiffCallback) {
    class MovieViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {
            binding.movie = item
            binding.executePendingBindings()
            binding.cardView.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    item.title,
                    item.poster_path,
                    item.release_date,
                    item.overview,
                    item.vote_average.toString()
                )
                binding.root.findNavController()
                    .navigate(action)
            }
            binding.likeImg.setOnClickListener {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }
}
