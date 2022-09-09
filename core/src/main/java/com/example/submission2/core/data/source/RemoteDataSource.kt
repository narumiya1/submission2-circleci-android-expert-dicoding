package com.example.submission2.core.data.source

import com.example.submission2.core.data.source.remote.netzwork.ApiResponse
import com.example.submission2.core.data.source.remote.netzwork.ApiService
import com.example.submission2.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import java.util.concurrent.Flow

class RemoteDataSource(private val apiService: ApiService) {
    private val apiKey = "d7c8dab1712dd172580ba39b448c1eb4"

    suspend fun getMovies(): kotlinx.coroutines.flow.Flow<ApiResponse<List<MovieResponse>>> {

        return flow{
            try {
                val response = apiService.getMovies(apiKey)
                val movieList = response.results
                if (movieList.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }
}