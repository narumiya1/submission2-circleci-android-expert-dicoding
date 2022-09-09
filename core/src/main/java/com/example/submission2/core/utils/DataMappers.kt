package com.example.submission2.core.utils

import com.example.submission2.core.data.source.local.entity.MovieEntity
import com.example.submission2.core.data.source.remote.response.ListMovieResponse
import com.example.submission2.core.data.source.remote.response.MovieResponse
import com.example.submission2.core.domaain.model.Movie

object DataMappers {
    fun mapMovieResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                it.overview,
                it.originalLanguage,
                it.releaseDate,
                it.popularity,
                it.voteAverage,
                it.id,
                it.title,
                it.voteCount,
                it.posterPath,
                favorite = false,
                isTvShows = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> {
        return input.map {
            Movie(
                it.overview,
                it.originalLanguage,
                it.releaseDate,
                it.popularity,
                it.voteAverage,
                it.id,
                it.title,
                it.voteCount,
                it.posterPath,
                favorite = it.favorite,
                isTvShows = it.isTvShows
            )
        }
    }
    fun mapDomainToEntity(input: Movie): MovieEntity {
        return MovieEntity(
            input.overview,
            input.originalLanguage,
            input.releaseDate,
            input.popularity,
            input.voteAverage,
            input.id,
            input.title,
            input.voteCount,
            input.posterPath,
            favorite = input.favorite,
            isTvShows = input.isTvShows
        )
    }
}