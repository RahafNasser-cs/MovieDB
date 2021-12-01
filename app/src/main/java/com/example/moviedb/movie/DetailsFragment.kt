package com.example.moviedb.movie

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedb.R
import com.example.moviedb.databinding.FragmentDetailsBinding
import com.example.moviedb.model.MovieViewModel
import com.example.moviedb.utility.ui.upToTop

class DetailsFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()
    lateinit var movieTitle: String
    lateinit var movieImageUrl: String
    lateinit var movieReleaseDate: String
    lateinit var movieDescription: String
    lateinit var movieVoteAverage: String
    lateinit var isFavMovie: String
    lateinit var backdropPath: String
    lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            movieTitle = it.getString(MOVIETITLE).toString()
            movieImageUrl = it.getString(MOVIEIMAGEURL).toString()
            movieReleaseDate = it.getString(MOVIERELEASEDATE).toString()
            movieDescription = it.getString(MOVIEDESCRIPTION).toString()
            movieVoteAverage = it.getString(MOVIEVOTEAVERAGE).toString()
            isFavMovie = it.getString(ISFAVMOVIE).toString()
            backdropPath = it.getString(BACKGROUNDPATH).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Overview"
        viewModel.movieTitle.value = movieTitle
        viewModel.movieImageUrl.value = movieImageUrl
        viewModel.movieDescription.value = movieDescription
        viewModel.movieReleaseDate.value = movieReleaseDate
        viewModel.movieVoteAverage.value = movieVoteAverage
        viewModel.isFavMovie.value = isFavMovie.toBoolean()
        viewModel.backdropPath.value = backdropPath
        if (viewModel.isFavMovie.value!!) {
            binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite)
        }
//        binding.likeImg.setOnClickListener {
//            if (!viewModel.isFavMovie.value!!) {
//                binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite)
//                viewModel.movie.value!!.find { it.title!! == viewModel.movieTitle.value!! }
//                    ?.let { it1 ->
//                        MovieViewModel.favMovieList.favMoviesList.add(
//                            it1
//                        )
//                    }
//                viewModel.isFavMovie.value = !viewModel.isFavMovie.value!!
//            } else {
//                binding.likeImg.setImageResource(R.drawable.ic_baseline_favorite_border)
//                viewModel.movie.value!!.find { it.title!! == viewModel.movieTitle.value!! }
//                    ?.let { it1 ->
//                        MovieViewModel.favMovieList.favMoviesList.remove(
//                            it1
//                        )
//                    }
//                viewModel.isFavMovie.value = !viewModel.isFavMovie.value!!
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite_page -> {
                findNavController().navigate(R.id.action_detailsFragment_to_favouriteFragment)
            }
            else -> {
                this.upToTop()
            }
        }
        return true
    }

    companion object {
        const val MOVIETITLE = "movieTitle"
        const val MOVIEIMAGEURL = "movieImageUrl"
        const val MOVIERELEASEDATE = "movieReleaseDate"
        const val MOVIEDESCRIPTION = "movieDescription"
        const val MOVIEVOTEAVERAGE = "movieVoteAverage"
        const val ISFAVMOVIE = "isFavMovie"
        const val BACKGROUNDPATH = "backdropPath"
    }
}
