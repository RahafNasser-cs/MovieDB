package com.example.moviedb.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviedb.databinding.FragmentHomeBinding
import com.example.moviedb.model.MovieViewModel

class HomeFragment : Fragment() {
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
        val binding = FragmentHomeBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = MovieGridAdapter()

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        return binding.root
    }

    fun goToNextFragment() {
//        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
        Toast.makeText(requireContext(), "goToNextFragment()", Toast.LENGTH_LONG).show()
    }
}
