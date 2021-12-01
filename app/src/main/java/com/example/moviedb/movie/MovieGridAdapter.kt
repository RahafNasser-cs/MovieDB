package com.example.moviedb.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.databinding.GridViewItemBinding
import com.example.moviedb.model.MovieViewModel.Companion.favMovieList
import com.example.moviedb.network.ResultsItem

class MovieGridAdapter(var flag: String) :
    ListAdapter<ResultsItem, MovieGridAdapter.MovieViewHolder>(DiffCallback) {
    lateinit var action: NavDirections

    inner class MovieViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {
            binding.movie = item
            binding.executePendingBindings()
            binding.movieImg.setOnClickListener {
                if (flag == "home") {
                    action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                        item.title,
                        item.poster_path,
                        item.release_date,
                        item.overview,
                        item.vote_average.toString()
                    )
                } else {
                    action = FavouriteFragmentDirections.actionFavouriteFragmentToDetailsFragment(
                        item.title,
                        item.poster_path,
                        item.release_date,
                        item.overview,
                        item.vote_average.toString()
                    )
                }
                binding.root.findNavController()
                    .navigate(action)
            }
            binding.likeImg.setOnClickListener {
                Log.d("adapter before", "${favMovieList.loadFavMovie()}")

                if (!item.isFavMovie) {
                    binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite)
                    favMovieList.favMoviesList.add(item)
                    item.isFavMovie = !item.isFavMovie
                } else {
                    binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite_border)
                    favMovieList.favMoviesList.removeAll { it.id == item.id }
                    item.isFavMovie = !item.isFavMovie
                }

                Log.d("adapter after", "${favMovieList.loadFavMovie()}")
            }
            if (item.isFavMovie) {
                binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite)
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
