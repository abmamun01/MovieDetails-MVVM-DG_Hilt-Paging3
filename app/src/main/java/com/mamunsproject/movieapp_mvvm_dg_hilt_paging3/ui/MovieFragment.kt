package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.ui



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.MovieViewModel
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.adapters.MoviePagingAdapter
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : Fragment() {

    lateinit var binding: FragmentMovieBinding

    val viewmodel: MovieViewModel by viewModels()

    val movieAdapter: MoviePagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieBinding.inflate(inflater, container, false)




        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRecyclerView()

        binding.movieSearch.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewmodel.setQuery(it)
                }



                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })


        viewmodel.list.observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }
    }

    private fun setRecyclerView() {

        binding.movieRecycler.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

}