package com.example.moviedb.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.databinding.GridViewItemBinding
import com.example.moviedb.network.MovieInfoResponse

class MovieGridAdapter :
    ListAdapter<MovieInfoResponse, MovieGridAdapter.MovieViewHolder>(DiffCallback) {
    class MovieViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieInfoResponse) {
            binding.movie = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieInfoResponse>() {
        override fun areItemsTheSame(
            oldItem: MovieInfoResponse,
            newItem: MovieInfoResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieInfoResponse,
            newItem: MovieInfoResponse
        ): Boolean {
            return oldItem.originalTitle == newItem.originalTitle
        }
    }
}
