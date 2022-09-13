package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.remote

import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("/s")
    suspend fun getAllMovies(
        @Query("s") search: String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String
    ): Response<MovieResponse>
}