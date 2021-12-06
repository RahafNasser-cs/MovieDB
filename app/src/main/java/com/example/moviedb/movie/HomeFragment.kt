package com.example.moviedb.movie

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedb.R
import com.example.moviedb.databinding.FragmentHomeBinding
import com.example.moviedb.model.MovieViewModel
import com.example.moviedb.network.MovieType

class HomeFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = MovieGridAdapter("home")
        binding.recyclerView.setHasFixedSize(true)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite_page -> {
                findNavController().navigate(R.id.action_homeFragment_to_favouriteFragment)
            }
            R.id.drama -> {
                viewModel.getMoviesById(MovieType.DRAMA.id)
            }
            R.id.history -> {
                viewModel.getMoviesById(MovieType.HISTORY.id)
            }
            R.id.war -> {
                viewModel.getMoviesById(MovieType.WAR.id)
            }
            R.id.western -> {
                viewModel.getMoviesById(MovieType.WESTERN.id)
            }
            R.id.thriller -> {
                viewModel.getMoviesById(MovieType.THRILLER.id)
            }
            R.id.tv_movie -> {
                viewModel.getMoviesById(MovieType.TV_MOVIE.id)
            }
            R.id.science_fiction -> {
                viewModel.getMoviesById(MovieType.SCIENCE_FICTION.id)
            }
            R.id.romance -> {
                viewModel.getMoviesById(MovieType.ROMANCE.id)
            }
            R.id.mystery -> {
                viewModel.getMoviesById(MovieType.MYSTERY.id)
            }
            R.id.music -> {
                viewModel.getMoviesById(MovieType.MUSIC.id)
            }
            R.id.horror -> {
                viewModel.getMoviesById(MovieType.HORROR.id)
            }
            R.id.fantasy -> {
                viewModel.getMoviesById(MovieType.FANTASY.id)
            }
            R.id.family -> {
                viewModel.getMoviesById(MovieType.FAMILY.id)
            }
            R.id.documentary -> {
                viewModel.getMoviesById(MovieType.DOCUMENTARY.id)
            }
            R.id.action -> {
                viewModel.getMoviesById(MovieType.ACTION.id)
            }
            R.id.adventure -> {
                viewModel.getMoviesById(MovieType.ADVENTURE.id)
            }
            R.id.crime -> {
                viewModel.getMoviesById(MovieType.CRIME.id)
            }
            R.id.animation -> {
                viewModel.getMoviesById(MovieType.ANIMATION.id)
            }
            R.id.comedy -> {
                viewModel.getMoviesById(MovieType.COMEDY.id)
            }
            R.id.no_filter -> {
                viewModel.getMoviesById(null)
            }
            R.id.sort_released_date -> {
                viewModel.sortMoviesByReleasedDate()
            }
        }
        return true
    }

    fun loadFilteredList(filterTag: MovieType) {
        viewModel.loadMovieList(filterTag)
    }
}
