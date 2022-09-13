package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.data

data class MovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)