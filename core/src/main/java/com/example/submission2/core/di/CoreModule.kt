package com.example.submission2.core.di

import com.example.submission2.core.data.MovieAppRepository
import com.example.submission2.core.data.source.RemoteDataSource
import com.example.submission2.core.data.source.local.LocalDataSource
import com.example.submission2.core.data.source.remote.netzwork.ApiService
import com.example.submission2.core.domaain.repositoryi.IMovieAppRespository
import com.example.submission2.core.utils.AppExcecutor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExcecutor() }
    single<IMovieAppRespository> { MovieAppRepository(get(), get(), get()) }
}
