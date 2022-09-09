package com.example.submission2

import com.example.submission2.core.data.MovieAppRepository
import com.example.submission2.core.domaain.model.Movie
import com.example.submission2.core.domaain.usecase.MovieAppInteractor
import com.example.submission2.core.domaain.usecase.MovieAppUseCase
import com.example.submission2.movies_ui.MoviesViewModel
import com.example.submission2.movies_ui.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val useCaseModule = module {
    factory<MovieAppUseCase> { MovieAppInteractor(get()) }
}

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}