package com.example.moviedb.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedb.databinding.FragmentDetailsBinding
import com.example.moviedb.model.MovieViewModel

class DetailsFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()
    lateinit var movieTitle: String
    lateinit var movieImageUrl: String
    lateinit var movieReleaseDate: String
    lateinit var movieDescription: String
    lateinit var movieVoteAverage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieTitle = it.getString(MOVIETITLE).toString()
            movieImageUrl = it.getString(MOVIEIMAGEURL).toString()
            movieReleaseDate = it.getString(MOVIERELEASEDATE).toString()
            movieDescription = it.getString(MOVIEDESCRIPTION).toString()
            movieVoteAverage = it.getString(MOVIEVOTEAVERAGE).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
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
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigateUp()
        }
    }

    companion object {
        const val MOVIETITLE = "movieTitle"
        const val MOVIEIMAGEURL = "movieImageUrl"
        const val MOVIERELEASEDATE = "movieReleaseDate"
        const val MOVIEDESCRIPTION = "movieDescription"
        const val MOVIEVOTEAVERAGE = "movieVoteAverage"
    }
}
