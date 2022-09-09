package com.example.submission2.core.domaain.usecase

import com.example.submission2.core.data.Resource
import com.example.submission2.core.domaain.model.Movie
import com.example.submission2.core.domaain.repositoryi.IMovieAppRespository
import kotlinx.coroutines.flow.Flow

class MovieAppInteractor(private val iMovieAppRespository: IMovieAppRespository) : MovieAppUseCase {

    override fun getAllMovies(sort: String): Flow<Resource<List<Movie>>> =
        iMovieAppRespository.getAllMoviesz(sort)


    override fun getSearchMovies(search: String): Flow<List<Movie>> =
        iMovieAppRespository.getSearchMovies(search)

}