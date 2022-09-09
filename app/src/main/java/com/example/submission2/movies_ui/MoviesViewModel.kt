package com.example.submission2.movies_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submission2.core.data.Resource
import com.example.submission2.core.domaain.model.Movie
import com.example.submission2.core.domaain.usecase.MovieAppUseCase

class MoviesViewModel(private val movieAppUseCase: MovieAppUseCase ) : ViewModel() {
    fun getMoves(sort: String): LiveData<Resource<List<Movie>>>{
        return movieAppUseCase.getAllMovies(sort).asLiveData()
    }
}