package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.paging.MoviePaging
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.remote.MovieInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieViewModel
@Inject constructor(private val movieInterface: MovieInterface) : ViewModel() {

    private val query = MutableLiveData<String>()

    val list = query.switchMap { query ->
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging(query, movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }


    fun setQuery(search: String) {
        query.postValue(search)
    }
}