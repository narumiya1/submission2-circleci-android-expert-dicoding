package com.example.submission2.core.data

import android.widget.Toast
import com.example.submission2.core.data.source.RemoteDataSource
import com.example.submission2.core.data.source.local.LocalDataSource
import com.example.submission2.core.data.source.remote.netzwork.ApiResponse
import com.example.submission2.core.data.source.remote.response.MovieResponse
import com.example.submission2.core.domaain.model.Movie
import com.example.submission2.core.domaain.repositoryi.IMovieAppRespository
import com.example.submission2.core.utils.AppExcecutor
import com.example.submission2.core.utils.DataMappers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieAppRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExcecutor
) : IMovieAppRespository {
    override fun getAllMoviesz(sort: String): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies(sort).map {
                    DataMappers.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMovies()

            }

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMappers.mapMovieResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }

        }.asFlow()


    override fun getSearchMovies(search: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

}