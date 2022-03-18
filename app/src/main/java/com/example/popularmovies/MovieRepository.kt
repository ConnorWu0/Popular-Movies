package com.example.popularmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.api.MovieService
import com.example.popularmovies.model.Movie
import java.lang.Exception

class MovieRepository(private val movieService: MovieService) {
    private val apiKey = "5406eed90e6b9c65f618ade1a15f626d"
    private val movieLiveData = MutableLiveData<List<Movie>>()
    private val errorLiveData = MutableLiveData<String>()

    val movies: LiveData<List<Movie>>
    get() = movieLiveData
    val error: LiveData<String>
    get() = errorLiveData
    suspend fun fetchMovies() {
        try {
            val popularMovies = movieService.getPopularMovies(apiKey)
            movieLiveData.postValue(popularMovies.results)
        }catch (exception: Exception){
            errorLiveData.postValue("An error occurred: ${exception.message}")
        }
    }
}