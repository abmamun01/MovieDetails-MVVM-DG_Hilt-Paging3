package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.paging

import androidx.paging.PagingSource
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.data.Movie
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.remote.MovieInterface
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.utils.Constants

class MoviePaging(val search: String, val movieInterface: MovieInterface) :
    PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        val page = params.key ?: 1


        return try {

            val data = movieInterface.getAllMovies(search, page, Constants.API_KEY)

            LoadResult.Page(
                data = data.body()?.Search!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.body()?.Search?.isEmpty()!!) null else page + 1
            )
        } catch (e: Exception) {

            LoadResult.Error(e)
        }

    }


}