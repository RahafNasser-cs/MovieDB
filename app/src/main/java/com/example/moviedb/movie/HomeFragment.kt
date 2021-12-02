package com.example.moviedb.movie

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
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

    fun goToNextFragment() {
//        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
        Toast.makeText(requireContext(), "goToNextFragment()", Toast.LENGTH_LONG).show()
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
                // loadFilteredList(MovieType.DRAMA)
                viewModel.getMoviesById(MovieType.DRAMA.id)
            }
            R.id.history -> {
                // loadFilteredList(MovieType.HISTORY)
                viewModel.getMoviesById(MovieType.HISTORY.id)
            }
            R.id.war -> {
                // loadFilteredList(MovieType.WAR)
                viewModel.getMoviesById(MovieType.WAR.id)
            }
            R.id.western -> {
                // loadFilteredList(MovieType.WESTERN)
                viewModel.getMoviesById(MovieType.WESTERN.id)
            }
            R.id.thriller -> {
                // loadFilteredList(MovieType.THRILLER)
                viewModel.getMoviesById(MovieType.THRILLER.id)
            }
            R.id.tv_movie -> {
                // loadFilteredList(MovieType.TV_MOVIE)
                viewModel.getMoviesById(MovieType.TV_MOVIE.id)
            }
            R.id.science_fiction -> {
                // loadFilteredList(MovieType.SCIENCE_FICTION)
                viewModel.getMoviesById(MovieType.SCIENCE_FICTION.id)
            }
            R.id.romance -> {
                // loadFilteredList(MovieType.ROMANCE)
                viewModel.getMoviesById(MovieType.ROMANCE.id)
            }
            R.id.mystery -> {
                // loadFilteredList(MovieType.MYSTERY)
                viewModel.getMoviesById(MovieType.MYSTERY.id)
            }
            R.id.music -> {
                // loadFilteredList(MovieType.MUSIC)
                viewModel.getMoviesById(MovieType.MUSIC.id)
            }
            R.id.horror -> {
                // loadFilteredList(MovieType.HORROR)
                viewModel.getMoviesById(MovieType.HORROR.id)
            }
            R.id.fantasy -> {
                // loadFilteredList(MovieType.FANTASY)
                viewModel.getMoviesById(MovieType.FANTASY.id)
            }
            R.id.family -> {
                // loadFilteredList(MovieType.FAMILY)
                viewModel.getMoviesById(MovieType.FAMILY.id)
            }
            R.id.documentary -> {
                // loadFilteredList(MovieType.DOCUMENTARY)
                viewModel.getMoviesById(MovieType.DOCUMENTARY.id)
            }
            R.id.action -> {
                // loadFilteredList(MovieType.ACTION)
                viewModel.getMoviesById(MovieType.ACTION.id)
            }
            R.id.adventure -> {
                // loadFilteredList(MovieType.ADVENTURE)
                viewModel.getMoviesById(MovieType.ADVENTURE.id)
            }
            R.id.crime -> {
                // loadFilteredList(MovieType.CRIME)
                viewModel.getMoviesById(MovieType.CRIME.id)
            }
            R.id.animation -> {
                // loadFilteredList(MovieType.ANIMATION)
                viewModel.getMoviesById(MovieType.ANIMATION.id)
            }
            R.id.comedy -> {
                // loadFilteredList(MovieType.COMEDY)
                viewModel.getMoviesById(MovieType.COMEDY.id)
            }
            R.id.no_filter -> {
                // loadFilteredList(MovieType.NULL)
                viewModel.getMoviesById(null)
            }
        }
        return true
    }

    fun loadFilteredList(filterTag: MovieType) {
        viewModel.loadMovieList(filterTag)
    }

//    override fun onResume() {
//        super.onResume()
//        binding.recyclerView.adapter = MovieGridAdapter("home")
//        binding.recyclerView.setHasFixedSize(true)
//        Log.d("filterd list", "${viewModel.movie.value}")
//    }

    fun test() {
        Log.d("Home Frag test()  ", "oooooo")
    }
}
