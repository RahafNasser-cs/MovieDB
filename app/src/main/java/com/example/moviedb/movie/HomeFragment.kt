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
                loadFilteredList(MovieType.DRAMA)
            }
            R.id.history -> {
                loadFilteredList(MovieType.HISTORY)
            }
            R.id.war -> {
                loadFilteredList(MovieType.WAR)
            }
            R.id.western -> {
                loadFilteredList(MovieType.WESTERN)
            }
            R.id.thriller -> {
                loadFilteredList(MovieType.THRILLER)
            }
            R.id.tv_movie -> {
                loadFilteredList(MovieType.TV_MOVIE)
            }
            R.id.science_fiction -> {
                loadFilteredList(MovieType.SCIENCE_FICTION)
            }
            R.id.romance -> {
                loadFilteredList(MovieType.ROMANCE)
            }
            R.id.mystery -> {
                loadFilteredList(MovieType.MYSTERY)
            }
            R.id.music -> {
                loadFilteredList(MovieType.MUSIC)
            }
            R.id.horror -> {
                loadFilteredList(MovieType.HORROR)
            }
            R.id.fantasy -> {
                loadFilteredList(MovieType.FANTASY)
            }
            R.id.family -> {
                loadFilteredList(MovieType.FAMILY)
            }
            R.id.documentary -> {
                loadFilteredList(MovieType.DOCUMENTARY)
            }
            R.id.action -> {
                loadFilteredList(MovieType.ACTION)
            }
            R.id.adventure -> {
                loadFilteredList(MovieType.ADVENTURE)
            }
            R.id.crime -> {
                loadFilteredList(MovieType.CRIME)
            }
            R.id.animation -> {
                loadFilteredList(MovieType.ANIMATION)
            }
            R.id.comedy -> {
                loadFilteredList(MovieType.COMEDY)
            }
            R.id.no_filter -> {
                loadFilteredList(MovieType.NULL)
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
