package com.example.submission2.core.domaain.repositoryi

import com.example.submission2.core.data.Resource
import com.example.submission2.core.domaain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieAppRespository {

    fun getAllMoviesz(sort : String) : Flow<Resource<List<Movie>>>
    fun getSearchMovies(search: String): Flow<List<Movie>>

}