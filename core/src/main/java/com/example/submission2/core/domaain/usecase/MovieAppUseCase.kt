package com.example.submission2.core.domaain.usecase

import com.example.submission2.core.data.Resource
import com.example.submission2.core.domaain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieAppUseCase {

    fun getAllMovies(sort: String): Flow<Resource<List<Movie>>>

    fun getSearchMovies(search: String): Flow<List<Movie>>

}