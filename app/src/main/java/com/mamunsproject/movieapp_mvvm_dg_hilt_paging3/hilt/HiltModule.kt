package com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.hilt

import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.remote.MovieInterface
import com.mamunsproject.movieapp_mvvm_dg_hilt_paging3.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object HiltModule {


    @Provides
    fun provideRetrfitInterface(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieInterface::class.java)
    }

}