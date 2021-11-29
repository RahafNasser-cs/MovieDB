package com.example.moviedb.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviedb.databinding.FragmentFavouriteBinding
import com.example.moviedb.model.MovieViewModel

class FavouriteFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavouriteBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = this@FavouriteFragment
            viewModel = this@FavouriteFragment.viewModel
            recyclerView.adapter = MovieGridAdapter("favourite")
        }
        viewModel.setFavMovieList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Favourite"
//        requireActivity().onBackPressedDispatcher.addCallback {
//            findNavController().navigateUp()
//        }
    }
}
