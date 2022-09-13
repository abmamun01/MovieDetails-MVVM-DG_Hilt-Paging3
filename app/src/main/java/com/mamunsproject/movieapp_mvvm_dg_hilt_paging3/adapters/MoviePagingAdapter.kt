package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.BR
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.data.Movie
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.databinding.ViewHolderMovieBinding

class MoviePagingAdapter : PagingDataAdapter<Movie, MoviePagingAdapter.MovieHolder>(DIFF_UTIL) {

    inner class MovieHolder(val viewDataBinding: ViewHolderMovieBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.viewDataBinding.setVariable(BR.movie, getItem(position))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val binding =
            ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieHolder(binding)
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }
}