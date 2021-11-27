package com.example.moviedb.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviedb.databinding.FragmentFavouriteBinding
import com.example.moviedb.model.MovieViewModel

class FavouriteFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavouriteBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = this@FavouriteFragment
            viewModel = this@FavouriteFragment.viewModel
        }
        return binding.root
    }
}
