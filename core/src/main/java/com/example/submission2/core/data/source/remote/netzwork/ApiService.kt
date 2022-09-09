package com.example.submission2.core.data.source.remote.netzwork

import com.example.submission2.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
    ): ListMovieResponse
}