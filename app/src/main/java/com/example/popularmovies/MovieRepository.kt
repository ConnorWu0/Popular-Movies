package com.example.popularmovies

import com.example.popularmovies.api.MovieService

class MovieRepository(private val movieService: MovieService) {
    private val apiKey = "5406eed90e6b9c65f618ade1a15f626d"
    fun fetchMovies() = movieService.getPopularMovies(apiKey)
}